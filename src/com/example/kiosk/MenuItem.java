package com.example.kiosk;

// 개별 음식 항목을 관리하는 MenuItem 클래스
public class MenuItem {
    private String name;
    private double price;
    private String description;

    //MenuItem 객체를 생성할때 호출되는 메서드
    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // 객체의 이름을 반환하는 getter 메서드
    public String getName() {
        return name;
    }
    // 객체의 가격을 반환하는 getter 메서드
    public double getPrice() {
        return price;
    }
    // 객체의 설명을 반환하는 getter 메서드
    public String getDescription() {
        return description;
    }


    // 객체의 이름, 가격 및 설명을 포함한 문자열을 반환하는 toString 메서드
    @Override
    public String toString() {
        return String.format("%s | W %.1f | %s", name, price, description);
    }
}