package bankManageme;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
// Những hành động phía user:
//+ inputInfo : scan
//        + display: sout (toString)
//        + Menu : show menu


        static Scanner scanner = new Scanner(System.in);
        public static void main(String[] args) {
            AccountManagement accountManagement = new AccountManagement();
            ArrayList<Account> accounts = accountManagement.getList();
            showMenu();
            while (true) {
                int number = scanner.nextInt();
                switch (number) {

                    case 1:
                        Account account = inputInfor();
                        accountManagement.addAccount(account);
                        break;
                    case 2:
                        System.out.println("Nhập ID bạn muốn xóa:");
                        long Id = scanner.nextLong();
                        Account one = accountManagement.searchByID(Id);
                        if ( one == null )
                        {
                            break;
                        }
                        accountManagement.removeAccount(one);
                        System.out.println("Đã xóa tài khoản trên thành công");
                        break;
                    case 3:
                        System.out.println("Nhập ID bạn muốn tìm kiếm : ");
                        long id  = scanner.nextLong();
                        Account two = accountManagement.searchByID(id);
                            if (two == accountManagement.searchByID(id))
                            {
                                System.out.println(two);
                            }
                        break;
                    case 4:
                        ArrayList<Account> accountList = accountManagement.getList();
                        for (Account acc: accountList) {
                            accountManagement.display(acc);
                        }
                        break;
                    case 5:
                        System.out.println(" Nhập ID cần nạp tiền : ");
                        long e = scanner.nextLong();
                        Account three = accountManagement.searchByID(e);
                        if (three == null ) {
                            break;
                        }
                        System.out.println("nhập số tiền cần nạp : ");
                        double money = scanner.nextDouble();
                        if ( money <= 0 ) {
                            System.out.println("Số tiền nạp không  hợp lệ : mời nhập lại !!!! ");
                             }
                        else {
                            three.addMoney(money);
                            System.out.println("Nạp tiền thành công");
                        }
                        break;
                    case 6:
                        System.out.println("Nhập ID khách hàng cần rút tiền : ");
                        long r = scanner.nextLong();
                        Account accountfour = accountManagement.searchByID(r);
                        if( accountfour ==  null){
                            break;
                        }
                        System.out.println("Nhập số tiền muốn rút:");
                        double money1 = scanner.nextDouble();
                        if ( money1 > accountfour.getAmount() && accountfour.getAmount() > 50000 )
                        {
                            System.out.println("Số tiền khách hàng muốn rút không hợp lệ : " +
                                    "Vui lòng nhập lại !!!");
                        }else {
                            accountfour.withdraw(money1);
                            System.out.println("Đã rút tiền  thành công " +
                                    "Cảm ơn quý khách !!! ");
                        }
                        break;
                    case 7:
                        System.out.println("Nhập số tài khoản khách hàng nhận tiền : ");
                        long s = scanner.nextLong();
                        System.out.println("Nhập số tiền  : ");
                        double money2 = scanner.nextDouble();
                        System.out.println("Nhập số tài khoản chuyển tiền : ");
                        long z = scanner.nextLong();
                        Account account1 = accountManagement.searchByID(s);
                        Account account2 = accountManagement.searchByID(z);
                      if (money2 > account2.getAmount()){
                          System.out.println("Số tiền bạn nhập ko hợp lệ : " +
                                  " Mời nhập lại !!!");
                      }
                      else {
                          account2.transfer(money2,account1);
                      }
                      break;
                    case 8:
                        showMenu();
                        break;
                    case 9:
                        return;
                    default:
                        System.out.println("Kính chào quý khách và hẹn gặp lại !!! ");
                        break;
                }

            }
        }

        public static void showMenu() {
            System.out.println("Welcome to the Agribank");
            System.out.println("Please choose an action: ");
            System.out.println("1. Add Account");
            System.out.println("2. Delete Account");
            System.out.println("3. Search Account");
            System.out.println("4. Display all");
            System.out.println("5. Add money for an account");
            System.out.println("6. Withdraw money from an account");
            System.out.println("7. Transfer money");
            System.out.println("8. Show menu");
            System.out.println("9. Exist");
        }

        public static Account inputInfor() {
            System.out.println("Please input infor of an account: ");
            System.out.print(" ID: ");
            long ID = scanner.nextLong();
            scanner.nextLine();
            System.out.print(" accountName: ");
            String accountName = scanner.nextLine();
            double initialMoney = 50000;
            return new Account(ID, accountName, initialMoney);
        }

    }
