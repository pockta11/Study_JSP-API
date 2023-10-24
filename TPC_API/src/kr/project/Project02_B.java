package kr.project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import kr.soldesk.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Project02_B {

	public static void main(String[] args) {
		String url = "https://sum.su.or.kr:8888/bible/today/Ajax/Bible/BosyMatter?qt_ty=QT1";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.print("[입력 -> 년(yyyy)-월(mm)-일(dd)] : ");
			String bible = br.readLine();
			url = url + "&Base_de=" + bible + "&bibleType=1"; // Base_de:날짜 bibleType:기본1
			System.out.println("========================================================");

			Document doc = Jsoup.connect(url).post(); // JSoup 연결

			Element bible_text = doc.select(".bible_text").first();// 주제목
			System.out.println(bible_text.text());

			Element bibleinfo_box = doc.select(".bibleinfo_box").first(); // 소제목
			System.out.println(bibleinfo_box.text());

			Elements liList = doc.select(".body_list > li"); // 내용
			for (Element li : liList) {
				System.out.print(li.select(".num").first().text() + ":");
				System.out.println(li.select(".info").first().text());
			}

			// 리소스(이미지, 소리, 영상) //*[@id="video"] /source
			Element tag = doc.select("source").first();
			String dPath = tag.attr("src").trim();
			System.out.println(dPath); // http://meditation.su.or.kr/meditation_mp3/2019/20191010.mp3
			String fileName = dPath.substring(dPath.lastIndexOf("/") + 1);
			System.out.println(fileName);

			// 이미지 다운로드
			Element tag1 = doc.select(".img > img").first();
			String dPath1 = "https://sum.su.or.kr:8888" + tag1.attr("src").trim();
			System.out.println(dPath1);
			String fileName1 = dPath1.substring(dPath1.lastIndexOf("/") + 1);

			// 다운로드
			Runnable r = new DownloadBroker(dPath1, fileName1);
			Thread dLoad = new Thread(r); // 스레드 구현
			dLoad.start();
			
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000); // 1초
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.print("" + (i + 1));
			}
			System.out.println();
			System.out.println("===============================");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}