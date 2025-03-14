package com.example.kiosk;

import java.util.List;

public class Menu {
    private String categoryName; // 메뉴 카테고리 이름
    private List<MenuItem> menuItems; //메뉴 카테고리에 속한 메뉴 항목

    public Menu(String categoryName, List<MenuItem> menuItems) {
        this.categoryName = categoryName;
        this.menuItems = menuItems;
    }

    // Getter 메서드
    public String getCategoryName() {
        return categoryName;
    }
    // Getter 메서드
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    // 메뉴 항목 출력
    public void displayMenu() {
        System.out.println("[ " + categoryName + " MENU ]");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, menuItems.get(i)); // 메뉴번호, 이름, 가격, 설명 출력
        }
        System.out.println("0. 뒤로가기"); //뒤로가기 옵션 추가
    }
}