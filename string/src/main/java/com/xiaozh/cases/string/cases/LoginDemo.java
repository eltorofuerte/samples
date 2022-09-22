package com.xiaozh.cases.string.cases;

import java.util.Scanner;

// 判断用户名和密码是否满足条件
public class LoginDemo {
    public static void main(String[] args) {
        String userName = "wq";
        String password = "123456";
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入用户名：");
            Scanner scanner = new Scanner(System.in);
            String loginName = scanner.nextLine();

            System.out.println("请输入用户密码：");
            Scanner sc2 = new Scanner(System.in);
            String loginPassword = sc2.nextLine();
            if (loginName.equals(userName) && loginPassword.equals(loginPassword)) {
                System.out.println("登陆成功");
                break;
            } else if (i == 2) {
                System.out.println("登陆失败");
            } else {
                System.out.println("错误，还有" + (2 - i) + "次机会");
            }
        }


    }

}
