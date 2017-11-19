public class FizzBuzz {

    public void fizzBuzz(){
        fizzBuzz(1);
    }

    private void fizzBuzz(int i){
        if(i==101)
            return;
        StringBuilder sB = new StringBuilder();
        sB.append(i).append(" ");
        if(i%3==0)
            sB.append("Fizz");
        if(i%5==0)
            sB.append("Buzz");
        System.out.println(sB.toString());
        fizzBuzz(++i);

    }
}
