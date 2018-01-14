
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Scanner;

public class kcposition {
	/** 
	*@Project:KanColleCoordinates舰娘立绘坐标文件生成器
	*@Author: a5566123s
	*@Date: 2018-1-13
	*@Copyright: weibo.com/a5566123s All rights reserved. 
	*/  
	public static void main(String[] args) {
		try {

			/* 读入api_start2文件 */
			String pathname = "C:\\Users\\menyi\\Desktop\\api_start2.txt";//输入api文件路径
			File filename = new File(pathname);

			FileInputStream fInputStream = new FileInputStream(filename);
			InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
			BufferedReader br = new BufferedReader(reader);
			String line = "";
			String str = "";
			while ((line = br.readLine()) != null) {
				str = str + line;
			}

			System.out.println("请输入swf文件名：");
			Scanner sc = new Scanner(System.in);
			String ch, ce;
			ce = sc.nextLine();
			ch = "\"" + ce;
			File writename = new File("C:\\Users\\menyi\\Desktop\\" + ce + ".config.ini");//输出config.ini文件路径
			writename.createNewFile(); // 创建新文件
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			int i = str.indexOf(ch);
			int j = str.indexOf("}", i);
			String c = "";
			for (; i <= j; i++) {
				c = c + str.charAt(i);
			}
			int flag = 0, k = 0, z = 0;
			String a = "";
			String b = "";
			String d = "";
			out.write("[graph]" + "\r\n");
			// System.out.println("[graph]");
			for (i = 0; i < c.length(); i++) {
				if ((c.charAt(i) + "").equals("\"")) {
					flag = flag % 2 + 1;
					z = 0;
					if (a.equals("") != true) {
						d = a;
					}
					a = "";
				}
				if (flag == 1) {
					if (z > 4) {
						if ((c.charAt(i) + "").equals("\"") != true) {
							a = a + c.charAt(i);
						}
					}
					z++;
				} else {
					if (c.charAt(i) > 47 && c.charAt(i) < 58 || c.charAt(i) == '-') {
						b = b + c.charAt(i);
					} else {
						if ((b.equals("") != true) && k == 0) {
							// System.out.println(d+"_left="+b);
							out.write(d + "_left=" + b + "\r\n");
							k = (k + 1) % 2;
						} else if ((b.equals("") != true) && k == 1) {
							// System.out.println(d+"_top="+b);
							out.write(d + "_top=" + b + "\r\n");
							k = (k + 1) % 2;
						}
						b = "";
					}
				}
			}

			out.flush(); // 把缓存区内容压入文件
			out.close(); // 最后记得关闭文件
			reader.close();
			br.close();
			System.out.println(ce + ".config.ini"+"坐标文件生成成功！");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
