package nsh.codility;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import java.time.Duration;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public abstract class AbstractGameOfCodes2022Test {
	abstract GameOfCodes2022Interface getTestObject();

	GameOfCodes2022Interface testObject;

	@BeforeEach
	void setup() {
		testObject = getTestObject();
	}

	@ParameterizedTest
	@MethodSource
	void test_samples(int E, String S) {
		assertEquals(E, testObject.solution(S));
	}

	static Stream<Arguments> test_samples() {
		return Stream.of( //
				Arguments.of(6, "aabacbba"), //
				Arguments.of(6, "aabxbaba"), //
				Arguments.of(11, "xxxyxxyyyxyyy"), //
				Arguments.of(5, "atheaxbtheb"));
	}

	@ParameterizedTest
	@MethodSource
	void test_samples1(int E, String S) {
		assertEquals(E, testObject.solution(S));
	}

	static Stream<Arguments> test_samples1() {
		return Stream.of( //
				Arguments.of(3, "aaa"), //
				Arguments.of(3, "abc"), //
				Arguments.of(3, "abcd"), //
				Arguments.of(3, "abcde"), //
				Arguments.of(3, "abcdef"), //
				Arguments.of(3, "abcdefghijklmnopqrstuvwxyz"), //
				Arguments.of(6, "aabacbb"), //
				Arguments.of(5, "abacbba"), //
				Arguments.of(100, "a".repeat(100)), //
				Arguments.of(5, "abababab"), //
				Arguments.of(4, "abcabc"), //
				Arguments.of(5, "abcabcabc"), //
				Arguments.of(7, "abc".repeat(5)), //
				Arguments.of(8, "abc".repeat(6)), //
				Arguments.of(8, "abcd".repeat(6)), //
				Arguments.of(4, "aaaa"));
	}

	private Duration getTimeoutDuration() {
		return Duration.ofMillis(2000);
	}

	@ParameterizedTest
	@MethodSource
	void test_long_1(int E, String S) {
		assertTimeoutPreemptively(getTimeoutDuration(), () -> assertEquals(E, testObject.solution(S)));
	}

	static Stream<Arguments> test_long_1() {
		return Stream.of( //
				Arguments.of(199998, "a".repeat(66666) + "b".repeat(66666) + "a".repeat(66666)), //
				Arguments.of(199998, "a".repeat(66666) + "b".repeat(66666) + "c".repeat(66666)), //
				Arguments.of(199998, "a".repeat(66666) + "b".repeat(66666) + "ef" + "c".repeat(66666)), //
				Arguments.of(200000, "a".repeat(99999) + "b".repeat(2) + "c".repeat(99999)), //
				Arguments.of(199999, "a".repeat(99999) + "be" + "c".repeat(99999)), //
				Arguments.of(66668, "abc".repeat(66666)), //
				Arguments.of(199999, "b" + "a".repeat(99999) + "c".repeat(99999) + "e"));
	}

}
