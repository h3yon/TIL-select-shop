package com.sparta.week02.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 파라미터가 없는 기본생성자를 대신 생성해줍니다. ex) Course()
@Entity // 테이블임을 나타냅니다.
public class Course extends Timestamped{

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다.
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String tutor;

    public Course(CourseRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }

    public Course(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }

    public void update(CourseRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }
}