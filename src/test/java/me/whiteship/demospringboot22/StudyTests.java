package me.whiteship.demospringboot22;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("스터디 테스트")
public class StudyTests {

    @Test
    @DisplayName("스터디 만들기")
    void createNewStudy() {
        Study study = Study.builder()
                .title("JUnit 5")
                .maxNumberOfParticipant(10)
                .build();

        assertNotNull(study);

        assertAll(
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), "New study's status should be DRAFT"),
                () -> assertEquals("JUnit 5", study.getTitle(), "Titles are not equals"),
                () -> assertEquals(10, study.getMaxNumberOfParticipant(), "MaxNumberOfParticipants are not equals"));
    }

    @Test
    @DisplayName("스터디 만들기 에러: 최대 참석자 수가 음수인 경우")
    void createNewStudyError_as_MaxNumberOfParticipant_is_minus() {
        assertThrows(IllegalArgumentException.class, () -> Study.builder()
            .title("JUnit 5")
            .maxNumberOfParticipant(-10)
            .build());
    }

}
