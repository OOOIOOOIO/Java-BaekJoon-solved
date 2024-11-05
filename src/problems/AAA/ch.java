package problems.AAA;

public class ch extends pa{


    public ch() {

        System.out.println("여긴 자식 기본 생성자");
    }

    public void aaaaa(){
        System.out.println("aaaa메서드");
    }


    @Override
    public void bbbb() {
        super.bbbb();
        System.out.println("오버라이드한 bbbb");

    }
}
