//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//class Start{
//    public static void main(String[] data){
//        System.out.println("Welcome to Football Club");
//        ApplicationContext context;
//        context = new ClassPathXmlApplicationContext("configure.xml");
//        Team t = context.getBean("team",Team.class);
//        System.out.println(t.getName());
//        System.out.println(t.getManager().getName());
//        System.out.println(t.getManager().getSalary());
//    }
//}
//class Team{
//    String name;
//    public void setName(String x){
//        name = x;
//    }
//    public String getName(){
//        return name;
//    }
//    Manager manager;
//    public void setManager(Manager n){
//        manager = n;
//    }
//    public Manager getManager(){
//        return manager;
//    }
//}
//
//class Manager{
//    String name;
//    double salary;
//    public void setName(String x){
//        name = x;
//    }
//    public String getName(){
//        return name;
//    }
//    public void setSalary(double x){
//        salary = x;
//    }
//    public double getSalary(){
//        return salary;
//    }
//}


 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.beans.factory.annotation.Qualifier;
 import org.springframework.context.ApplicationContext;
 import org.springframework.context.annotation.AnnotationConfigApplicationContext;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;

class Start{
    public static void main(String[] data){
        System.out.println("Welcome to Airbus A320");
        ApplicationContext context;
        context = new AnnotationConfigApplicationContext(Prepare.class);
        Plane main = (Plane)context.getBean("main");
        System.out.println(main.model);
        System.out.println(main.captain.name);
    }//Dependency Injection = Instance Wiring
}// 1.Direct 2 Property 3 Constructor


@Configuration
class Prepare{
    @Bean("main")
    Plane createMain(){
        Plane p = new Plane();
        p.model = "Boeing 747";
        return p;
    }
    @Bean("a")
    Captain createJames(){
        Captain c = new Captain();
        c.name = "James Bond";
        c.salary = 47000.0;
        return c;
    }
    @Bean("j")
    Captain createEthan(){
        Captain c = new Captain();
        c.name = "Ethan Hunt";
        c.salary = 38000.0;
        return c;
    }
}

class Captain {
    String name;
    double salary;
}

class Plane { 
    String model;
    
    @Autowired @Qualifier("j")
    Captain captain;
    public void setCaptain(Captain c){
        captain = c;
    }
}
