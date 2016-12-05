package jp.co.nhkmt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MainDiff {
	private static final String dirPath = "C:\\Users\\seki-2014\\difflist\\";
	private static final String listFile = "new_PLNSVR0_share.txt";
	private static final String serchFile = "PLNSVR0_share.txt";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String serchlist = "";
		try {
			//serchFileのデータを変数に読み込む
			FileReader in2 = new FileReader(dirPath+serchFile);
			BufferedReader br2 = new BufferedReader(in2);

			ArrayList<String> serchArr = new ArrayList<String>();
			String line=null;
			while ((line = br2.readLine()) != null) {
				serchArr.add(line);
			}
			br2.close();
			in2.close();

			//listFileのデータを1行ずつ読み込んで比較
			FileReader in1 = new FileReader(dirPath+listFile);
			BufferedReader br1 = new BufferedReader(in1);
			String line1=null;
			while ((line1 = br1.readLine()) != null) {
				String line2=null;
				boolean flg = false;
		        for (int i = 0; i < serchArr.size(); i++) {
		        	line2 = serchArr.get(i);
					if(line1.equals(line2)){
						flg = true;
						break;
					}
				}
				if(!flg){
					System.out.println(line1);
				}
			}
			br1.close();
			in1.close();

		} catch (IOException e) {
			System.out.println(e);
		} finally {
			System.out.println("END");
		}

	}

}
