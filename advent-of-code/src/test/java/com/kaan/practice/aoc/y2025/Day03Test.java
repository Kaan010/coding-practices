package com.kaan.practice.aoc.y2025;

import static com.kaan.practice.common.InputReader.readLines;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.kaan.practice.common.InputReader;
import org.junit.jupiter.api.Test;

class Day03Test {

    @Test
    void part1_example() {
        var day = new Day03();
        List<String> inputTest = List.of(
                "987654321111111",
                "811111111111119",
                "234234234234278",
                "818181911112111"
        );
        assertEquals(357, day.part1(inputTest));


        List<String> inputReal = readLines("aoc/2025/day03.txt");
        System.out.println("Part 1 answer: " + day.part1(inputReal)); //17524
    }

    @Test
    void part2_example() {
        var day = new Day03();
        List<String> inputTest = List.of(
//                "987654321111111",
//                "811111111111119",
                "234234234234278",
                "818181911112111"
        );
        assertEquals(3121910778619L, day.part2_another_approach(inputTest));


        List<String> inputReal = readLines("aoc/2025/day03.txt");
        System.out.println("Part 2 answer: " + day.part2_another_approach(inputReal)); //173848577117276
    }
}
