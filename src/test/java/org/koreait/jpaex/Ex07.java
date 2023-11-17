package org.koreait.jpaex;

import org.junit.jupiter.api.BeforeEach;
import org.koreait.entities.BoardData;
import org.koreait.entities.HashTag;
import org.koreait.repositories.BoardDataRepository;
import org.koreait.repositories.HashTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class Ex07 {

    @Autowired
    private BoardDataRepository boardDataRepository;

    @Autowired
    private HashTagRepository hashTagRepository;

    @BeforeEach
    void init() {
        List<HashTag> tags = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            HashTag tag = new HashTag();
            tag.setTag("태그" + i);
            tags.add(tag);
        }

        hashTagRepository.saveAllAndFlush(tags);

        List<BoardData> items = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            BoardData item = BoardData.builder()
                    .subject("제목" + i)
                    .content("내용" + i)
                    .tags(tags)
                    .build();
            items.add(item);
        }

        boardDataRepository.saveAllAndFlush(items);
    }
}
