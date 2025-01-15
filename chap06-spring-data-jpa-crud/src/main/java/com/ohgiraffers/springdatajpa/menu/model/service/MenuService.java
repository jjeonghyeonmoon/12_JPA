package com.ohgiraffers.springdatajpa.menu.model.service;

import com.ohgiraffers.springdatajpa.menu.entity.Category;
import com.ohgiraffers.springdatajpa.menu.entity.Menu;
import com.ohgiraffers.springdatajpa.menu.model.dao.CategoryRepository;
import com.ohgiraffers.springdatajpa.menu.model.dao.MenuRepository;
import com.ohgiraffers.springdatajpa.menu.model.dto.CategoryDTO;
import com.ohgiraffers.springdatajpa.menu.model.dto.MenuDTO;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuService {


    private final MenuRepository repository;
    // Bean 으로 등록한 modelmapper 의존성 주입
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    /* 1. 메뉴 코드로 특정 메뉴 조회하기*/
    public MenuDTO findMenuByMenuCode(int menuCode) {
        Menu foundMenu = repository.findById(menuCode)
                                    // 잘 못 된 파라미터가 넘겨왔을 때 예외처리 필수
                                    .orElseThrow(IllegalArgumentException::new);
        // entity -> dto
        // map(변환 대상, 변환 할 타입)
        return modelMapper.map(foundMenu, MenuDTO.class);

    }

    /* 페이징 처리하지 않은 메뉴 리스트 조회하기 */
    public List<Menu> findMenuList() {
        // List<Menu> menuList = repository.findAll(); 정렬 없는 findALL
        List<Menu> menuList = repository.findAll(Sort.by("menuPrice").descending());
        // stream : 컬렉션(List 등등) 데이터를 처리하기 위해 나열
        return menuList.stream()
                // map: 스트림화 된 데이터를 꺼내 매핑 및 변환
                .map(menu -> modelMapper.map(menu, Menu.class))
                // collect :스트림화 된 데이터를 다시 list 로 변환
                .collect(Collectors.toList());
    }

    /* 페이징 처리를 한 메뉴 전체 조회*/
    public Page<MenuDTO> findMenuListByPaging(Pageable pageable) {

        pageable = PageRequest.of(
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() -1,
                pageable.getPageSize(),
                Sort.by("menuCode").descending()
        );


        Page<Menu> menuList = repository.findAll(pageable);

        return menuList.map(
                menu -> modelMapper.map(menu,MenuDTO.class)
        );


    }

    public List<MenuDTO> findByMenuPrice(int menuPrice) {

        List<Menu> menuList = repository.findByMenuPriceGreaterThanOrderByMenuPrice(menuPrice);

        return menuList.stream()
                .map(
                menu -> modelMapper.map(menu, MenuDTO.class)
        ).collect(Collectors.toList());

    }

    public List<CategoryDTO> findAllCategory() {

        List<Category> categoryList
                = categoryRepository.findAllCategory();

        return categoryList.stream().map(
                category -> modelMapper.map(category,CategoryDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void registerMenu(MenuDTO menuDTO) {
        Menu menuEntity = modelMapper.map(menuDTO, Menu.class);
        repository.save(menuEntity);
    }
}
