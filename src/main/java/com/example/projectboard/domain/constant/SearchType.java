package com.example.projectboard.domain.constant;

import lombok.Getter;

public enum SearchType {
    TITLE("제목"),
    CONTENT("본문"),
    ID("유저 ID"),
    NICKNAME("닉네임"),
    HASHTAG("해시태그");

    @Getter
    private final String description;

    SearchType(String description) {
        this.description = description;
    }
//자바 Enum은 상수 컬렉션을 정의하는 데 쓰이는 특수한 자바 유형(type)이다. 더 정확하게 말하면 enum은 특수한 자바 클래스다. 열거형에는 상수, 메서드 등이 포함될 수 있으며 자바 5부터 추가되었다
}
