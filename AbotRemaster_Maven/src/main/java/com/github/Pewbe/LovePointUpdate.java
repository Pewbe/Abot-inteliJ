package com.github.Pewbe;

import java.io.*;

public class LovePointUpdate{
    public void loveUp( int love, long userId ){
        String buff;
        String[] splited;
        boolean successfulyUpdated = false;


        try {
            if( love > 0 ) {
                String path = "D:\\somthing I made\\AbotRemaster_Maven\\LovePoint.txt";
                BufferedReader br = new BufferedReader(new FileReader(path));
                BufferedWriter bw = new BufferedWriter(new FileWriter(path));

                System.out.println("증가될 호감도가 있네요.");
                while ((buff = br.readLine()) != null) {
                    System.out.println("누구에게 증가시키면 되는지 찾는 중이예요...");
                    splited = buff.split("#");//0: [호감도], 1: [유저아이디]
                    if( userId == Long.parseLong( splited[1] ) ){
                        System.out.println("호감도를 증가시킬 유저를 찾았어요!");
                        splited[0] += love;
                        love = 0;//splited[0]에는 증가된 호감도가 들어가있음
                        bw.write(splited[0] + "#" + splited[1] + "\n");
                        bw.flush();

                        System.out.println("성공적으로 호감도를 증가시켰어요. 해당 유저의 최종 호감도: " + splited[0]);
                        System.out.println("수정된 문자열: " + splited[0] + "#" + splited[1]);

                        successfulyUpdated = true;
                    }
                }
                if( !successfulyUpdated ){
                    System.out.println("이 유저는 호감도 증가가 처음인가 봐요.");
                    bw.write(love + "#" + userId + "\n");
                    System.out.println("추가된 문자열: " + love + "#" + userId);
                    love = 0;//splited[0]에는 증가된 호감도가 들어가있음
                }
                System.out.println("호감도를 성공적으로 증가했어요!");

                br.close();
                bw.close();
            } else {
                System.out.println("어라..? 증가할 호감도가 없는걸요.. 오류일까요?");
            }
        } catch ( Exception e ){ e.printStackTrace(); }
    }
}