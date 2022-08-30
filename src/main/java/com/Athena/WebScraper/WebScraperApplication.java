package com.Athena.WebScraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.logging.Logger;

@SpringBootApplication
public class WebScraperApplication {

	private final static Logger LOGGER =
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void main(String[] args) throws IOException {
		SpringApplication.run(WebScraperApplication.class, args);

		Document doc = Jsoup.connect("https://en.wikipedia.org/").get();
		LOGGER.info(doc.title());
		Elements newsHeadlines = doc.select("#mp-itn b a");
		for (Element headline : newsHeadlines) {
			System.out.println("headline: " +headline.attr("title") + "     " + "href: " + headline.attr("href"));
		}


	}

}
