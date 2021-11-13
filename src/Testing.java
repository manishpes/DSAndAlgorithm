public class Testing {
    public static void main(String[] args) {
        Thread t1 ;
        Thread t2 ;
        Object obj1 = new Object();
        Object obj2 = new Object();


       t1 = new Thread(){

        public void run()
        {
            synchronized (obj1){

                try {
                    System.out.println("Thread 1 locked resource 1");
                    Thread.sleep(100);

                } catch (Exception e){
                    System.out.println("");
                }

                synchronized (obj2) {
                    System.out.println("Thread 1: locked resource 2");
                }

            }
        }
        };

       t2 = new Thread(){

           public void run() {
            synchronized (obj2) {
                try {
                    System.out.println("Thread 2 locked resource 2");
                    Thread.sleep(100);
                } catch (Exception e) {

                }

                synchronized (obj1) {
                    System.out.println("Thread 2 locked resource 1");
                }
            }

           }
       };

        t1.start();
        t2.start();
    }
}
/*

Table - EmployeeDetails

        EmpId    FullName    ManagerId    DateOfJoining

        121    John Snow    321   	 01/31/2014
        321    Walter White    986   	 01/30/2015
        421    Kuldeep Rana    876   	 27/11/2016


        Table - EmployeeSalary

        EmpId    Project    Salary

        121    P1    8000
        321    P2    1000
        421    P1    12000

        P1 = 2
        P2 = 1

   select Project, count(*) from EmployeeSalary group by Project;

  select ed.FullName from EmployeeDetails as ed, EmployeeSalary as es where  es.EmpId = ed.EmpID and  ed.Project=
  'P1';

   select count(*) from EmployeeSalary where Project= 'P1';

    select ed.FullName from EmployeeDetails where EmpId in ( select EmpId from EmployeeSalary where Project= 'P1');


 */