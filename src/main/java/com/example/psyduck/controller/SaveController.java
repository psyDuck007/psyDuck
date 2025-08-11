package com.example.psyduck.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SaveController {

    @GetMapping("/save")
    public String save(@RequestParam String url, @RequestParam String file) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements paragraphs = doc.select("p");
        List<String> lines = paragraphs.stream()
                .map(Element::text)
                .collect(Collectors.toList());
        Files.write(Paths.get(file), lines, StandardCharsets.UTF_8);
        return "Saved " + lines.size() + " paragraphs to " + file;
    }
}
