package Task_Zoo;

public class Main {
    public static void main(String[] args) {
        PredatorFactory pFactory = new PredatorFactory();

        ScandinavianPredators fWolf = pFactory.newFemaleWolf(20201010, "cage 1", "Maleneulv", 19941108, 10);
        ScandinavianPredators mWolf = pFactory.newMaleWolf(20201010, "cage 2", "Terjeulv", 19950302);
        ScandinavianPredators fBear = pFactory.newFemaleBear(20201010, "cage 3", "Malenebjørn", 19801010, 10);
        ScandinavianPredators mBear = pFactory.newMaleBear(20201010, "cage 3", "TerjeBjørn", 19950203);


        System.out.println("6 Tests from the PredatorFactory-class and ScandinavianPredator interface:");
        System.out.println("----------------------------------------------------------------------------");
        //Test1:
        if(fWolf.getName().equals("Maleneulv") && fWolf.getAddresse().equals("cage 1")){
            System.out.println("Test 1 successfull");
        }

        //Test2:
        if(mWolf.getName().equals("Terjeulv") && mWolf.getFdate() == 19950302){
            System.out.println("Test 2 successfull");
        }

        //Test3:
        String newAddresse = "Cage 1995";
        fBear.move(newAddresse);
        if(fBear.getAddresse().equals("Cage 1995")){
            System.out.println("Test 3 successfull");
        }

        //Test4:
        if(mBear.getAge() == 25){
            System.out.println("Test 4 successfull");
        }

        //Test 5:
        if(fBear.getAmLitter() == 10){
            System.out.println("Test 5 successfull");
        }
        //Test 6:
        if(mBear.writeInfo().equals("Individual{name='TerjeBjørn', fDate=19950203, male=true, dangerous=true}") && mBear.getAmLitter() == 0){
            System.out.println("Test 6 successfull");
        }
    }
}
