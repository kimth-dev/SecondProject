package com.example.kiosk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus; // 여러 메뉴를 담는 리스트
    private Scanner scanner;

    //메뉴 리스트 초기화 및 메뉴 추가
    public Kiosk() {
        menus = new ArrayList<>();
        scanner = new Scanner(System.in);

        // MenuItem 객체를 담을 빈 리스트 burgerItems 생성
        List<MenuItem> burgerItems = new ArrayList<>();
        // MenuItem 객체를 BurgerItems 리스트에 추가
        burgerItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgerItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        //burgerItems 에 포함된 여러 MenuItem 객체들을 Burgers 라는 카테고리 이름과 함께 하나의 Menu 객체로 묶어 menus 리스트에 추가
        menus.add(new Menu("Burgers", burgerItems));

        // MenuItem 객체를 담을 빈 리스트 drinkItems 생성
        List<MenuItem> drinkItems = new ArrayList<>();
        // MenuItem 객체를 drinkItems 리스트에 추가
        drinkItems.add(new MenuItem("Coke", 2.5, "콜라"));
        drinkItems.add(new MenuItem("Zero Coke", 2.5, "제로콜라"));
        drinkItems.add(new MenuItem("Sprite", 2.5, "스프라이트"));
        //drinkItems 에 포함된 여러 MenuItem 객체들을 Drinks 라는 카테고리 이름과 함께 하나의 Menu 객체로 묶어 menus 리스트에 추가
        menus.add(new Menu("Drinks", drinkItems));

        // MenuItem 객체를 담을 빈 리스트 dessertItems 생성
        List<MenuItem> dessertItems = new ArrayList<>();
        // MenuItem 객체를 dessertItems 리스트에 추가
        dessertItems.add(new MenuItem("Chocolate Cake", 4.0, "초콜릿 케이크"));
        dessertItems.add(new MenuItem("Apple pie", 2.0, "애플 파이"));
        dessertItems.add(new MenuItem("Soft Ice Cream", 1.0, "소프트 아이스크림"));
        //dessertItems 에 포함된 여러 MenuItem 객체들을 Desserts 라는 카테고리 이름과 함께 하나의 Menu 객체로 묶어 menus 리스트에 추가
        menus.add(new Menu("Desserts", dessertItems));
    }

    // 메뉴 종류 출력
    public void displayMainMenu() {
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, menus.get(i).getCategoryName());
        }
        System.out.println("0. 종료");
    }

    // 메뉴 종류 선택 후 카테고리별 메뉴 출력
    public void selectMenu() {
        while (true) {
            displayMainMenu();
            System.out.print("메뉴 종류를 선택하세요: ");
            try {
                int choice = scanner.nextInt();
                if (choice == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if (choice > 0 && choice <= menus.size()) {
                    Menu selectedMenu = menus.get(choice - 1);
                    selectedMenu.displayMenu();

                    System.out.print("메뉴 번호를 선택하세요: ");
                    int menuchoice = scanner.nextInt();
                    if (menuchoice == 0) {
                        continue; // 뒤로 가기
                    }

                    // 유효한 메뉴 번호 선택 시
                    if (menuchoice > 0 && menuchoice <= selectedMenu.getMenuItems().size()) {
                        MenuItem selectedItem = selectedMenu.getMenuItems().get(menuchoice - 1);
                        System.out.println("선택한 메뉴: " + selectedItem.getName() + "|" + selectedItem.getPrice() + "|" + selectedItem.getDescription());
                    } else {
                        System.out.println("잘못된 입력입니다.");
                    }
                } else {
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                }
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 숫자만 입력해주세요.");
                scanner.nextLine();
            }
        }
    }
}