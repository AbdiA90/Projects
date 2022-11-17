import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();
       
        int randomCard1 = drawRandomCard();
        int randomCard2 = drawRandomCard();
        
        System.out.println(" \n You get a \n" + cardString(randomCard1) + "\n and a \n" + cardString(randomCard2));
        int total = Math.min(randomCard1, 10) + Math.min(randomCard2, 10);
        System.out.println("your total is " + total);
       
        int dealerCard1 = drawRandomCard();
        int dealerCard2 = drawRandomCard();
        
        System.out.println("The dealer shows \n" + cardString(dealerCard1) + "\nand has a card facing down \n" + faceDown());
        int dealerTotal= Math.min(dealerCard1,10) + Math.min(dealerCard2, 10);
        
        while (true) {
            int newDraw = drawRandomCard();
            String hit = hitOrStay();
            if (hit.equals("stay")) {
                break;
           }else{
                System.out.println("\n You get a \n" + cardString(newDraw));
                total += Math.min(newDraw, 10);
                System.out.println("Your total is " + total);
                if(total > 21){
                    System.out.println("Bust! Player loses.");
                    System.exit(0);

                }
           } 
            
        }
        
    
        System.out.println("\n Dealer's turn");
        System.out.println("\n The dealers card are \n" + cardString(dealerCard1) + "\n and a\n" + cardString(dealerCard2));

        System.out.println("\nDealer's total is " + dealerTotal);

        while (dealerTotal < 17) {
            int newCard = drawRandomCard();
            System.out.println("\nDealer gets a a\n" + cardString(newCard));
            dealerTotal += Math.min(newCard,10);
            System.out.println("\nDealer's total is " + dealerTotal);
        }

        if (dealerTotal > 21) {
            System.out.println("Bust! Dealer loses.");
            System.exit(0);
        }

        if (total > dealerTotal) {
            System.out.println("Player Wins!");
        }else {
            System.out.println("Dealer Wins");
        }
        
         scan.close();

    }

    public static int drawRandomCard() {
        double randomNumber = Math.random() * 13;
        randomNumber += 1;
        int card = (int)randomNumber;
        return card;
    }

    public static String cardString(int cardNumber) {
        switch (cardNumber) {
            case 1: return  "   _____\n"+
                            "  |A _  |\n"+ 
                            "  | ( ) |\n"+
                            "  |(_'_)|\n"+
                            "  |  |  |\n"+
                            "  |____V|\n";
                            
            case 2: return  "   _____\n"+              
                            "  |2    |\n"+ 
                            "  |  o  |\n"+
                            "  |     |\n"+
                            "  |  o  |\n"+
                            "  |____Z|\n";
          
            
            case 3: return  "   _____\n" +
                            "  |3    |\n"+
                            "  | o o |\n"+
                            "  |     |\n"+
                            "  |  o  |\n"+
                            "  |____E|\n";
            
            case 4: return  "   _____\n" +
                            "  |4    |\n"+
                            "  | o o |\n"+
                            "  |     |\n"+
                            "  | o o |\n"+
                            "  |____h|\n";
            
            case 5: return  "   _____ \n" +
                            "  |5    |\n" +
                            "  | o o |\n" +
                            "  |  o  |\n" +
                            "  | o o |\n" +
                            "  |____S|\n";
            
            case 6: return  "   _____ \n" +
                            "  |6    |\n" +
                            "  | o o |\n" +
                            "  | o o |\n" +
                            "  | o o |\n" +
                            "  |____6|\n";
            
            case 7: return  "   _____ \n" +
                            "  |7    |\n" +
                            "  | o o |\n" +
                            "  |o o o|\n" +
                            "  | o o |\n" +
                            "  |____7|\n";
                        
            
            case 8: return  "   _____ \n" +
                            "  |8    |\n" +
                            "  |o o o|\n" +
                            "  | o o |\n" +
                            "  |o o o|\n" +
                            "  |____8|\n";
            
            case 9: return  "   _____ \n" +
                            "  |9    |\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |____9|\n";
                            
            
            case 10: return "   _____ \n" +
                            "  |10  o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |o o o|\n" +
                            "  |___10|\n";
                            
            case 11: return "   _____\n" +
                            "  |J  ww|\n"+ 
                            "  | o {)|\n"+ 
                            "  |o o% |\n"+ 
                            "  | | % |\n"+ 
                            "  |__%%[|\n";
                            
            case 12: return "   _____\n" +
                            "  |Q  ww|\n"+ 
                            "  | o {(|\n"+ 
                            "  |o o%%|\n"+ 
                            "  | |%%%|\n"+ 
                            "  |_%%%O|\n";
            
            case 13: return "   _____\n" +
                            "  |K  WW|\n"+ 
                            "  | o {)|\n"+ 
                            "  |o o%%|\n"+ 
                            "  | |%%%|\n"+ 
                            "  |_%%%>|\n";
                                
            default: return "";
            


        }

    }

    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
    
    public static String hitOrStay() {
        System.out.println("Do you want to hit or stay?");
        String hitOrStay = scan.nextLine();
        while (true) {
            if (hitOrStay.equals("stay")){
                break;
            }else if (hitOrStay.equals("hit")){
                break;
            }else{
                System.out.println("Please try again. Please write 'hit' or 'stay'");
                hitOrStay = scan.nextLine();
                continue;
            }
        } 
        return hitOrStay;
    }
    }

