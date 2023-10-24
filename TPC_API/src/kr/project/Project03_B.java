package kr.project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;

public class Project03_B {
	public static void main(String[] args) {

		try {

			Workbook wb = new HSSFWorkbook(); // 워크북 생성(엑셀파일 생성)
			Sheet sheet = wb.createSheet("My Sample Excel"); // Sheet 생성
			// 이미지 파일 읽어오기 : 이미지 -> byte -> int
			InputStream is = new FileInputStream("C:\\Web_20230726\\TPC_API\\pic.jpg");
			byte[] bytes = IOUtils.toByteArray(is); // 이미지를 바이트 배열로 변형해야함
			// 워크북 안 메모리에 이미지 load
			int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
			is.close();

			// 실제로 이미지 드로잉을 도와주는 메소드
			CreationHelper helper = wb.getCreationHelper();
			Drawing drawing = sheet.createDrawingPatriarch(); // 시트에 이미지 드로잉 객체 생성
			ClientAnchor anchor = helper.createClientAnchor(); // 그림 그릴 위치 지정

			anchor.setCol1(1); // 1번째 컬럼
			anchor.setRow1(2); // 2번째 줄
			anchor.setCol2(2); // 2번째 컬럼
			anchor.setRow2(3); // 3번째 줄

			Picture pict = drawing.createPicture(anchor, pictureIdx);

			Cell cell = sheet.createRow(2).createCell(1);
			int w = 20 * 256 * 1 / 256; // 폭 하나당 256분의 1
			sheet.setColumnWidth(1, w); // 폭 설정
			
			short h = 120 * 20; // 폭 하나당 20
			cell.getRow().setHeight(h); // 높이 설정
			
			// Excel 파일 생성
			FileOutputStream fileOut = new FileOutputStream("myFile.xls");
			wb.write(fileOut); // 파일 이미지 저장
			fileOut.close();
			System.out.println("이미지 저장 완료");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
