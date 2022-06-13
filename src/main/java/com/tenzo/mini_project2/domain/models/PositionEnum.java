package com.tenzo.mini_project2.domain.models;

public enum PositionEnum {
    TOP("top"),
    BOTTOM("bottom"),
    LEFT("left"),
    RIGHT("right");

    private String position;
    PositionEnum(String positionForImg) {
        this.position = positionForImg;
    }

    public String getPosition() {
        return position;
    }

    // 위와같이 만들경우 필드에 있는 문자열을 가지고 올 수 있다.
}
