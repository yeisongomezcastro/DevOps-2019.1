package io.quind.training.basicconsoleapp.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MemberTest {

    @DisplayName("Should return return correct to string value")
    @ParameterizedTest(name = "{index} => memberID = {0}, memberType = {1}, name = {2}, fees = {3} ")
    @CsvSource({
            "1, S, Name1, 100",
            "2, M, Name2, 300",
            "3, M, Name3, 200"
    })
    void testToString(int memberID, char memberType, String name, double fees) {
        Member member = new Member(memberID, memberType, name, fees);
        String expected = String.format("%s, %s, %s, %.1f", memberID, memberType, name, fees);
        assertEquals(expected, member.toString());
    }
}