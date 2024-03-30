import br.com.alura.models.CreditCard;
import br.com.alura.models.Purchase;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CreditCard card01 = new CreditCard();
        String purchaseDescription;
        double purchaseValue;
        int oneOrZero = 3;
        System.out.println("Qual o limite do cartão?");
        card01.setLimit(input.nextDouble());
        while (card01.getSystem()) {

            System.out.println("Digite a descrição da compra:");
            purchaseDescription = input.next();
            System.out.println("Digite o valor da compra:");
            purchaseValue = input.nextDouble();

            if (oneOrZero == 1 || oneOrZero == 0) {
                oneOrZero = 3;
            }

            if (purchaseValue > card01.getLimit()) {
                System.out.println("Você não tem limite para fazer essa compra");
                System.out.println("Seu limite é: " + card01.getLimit());
                while (oneOrZero != 0 && oneOrZero != 1) {
                    System.out.println("Para realizar uma nova compra digite 1 para sair do sistema digite 0.");
                    oneOrZero = input.nextInt();
                    if (oneOrZero == 1) {
                        continue;
                    } else if (oneOrZero == 0) {
                        System.out.println("COMPRAS REALIZADAS: ");
                        for (Purchase c : card01.getPurchasesList()) {
                            System.out.println(c.getPurchaseName() + "-" + c.getPurchasePrice());
                        }
                        card01.setSystem(false);
                    } else {
                        System.out.println("Opção inválida, tente novamente");
                    }
                }
            }else if (purchaseValue <= card01.getLimit()) {
                System.out.println("Compra realizada com sucesso");
                Purchase purchase01 = new Purchase(purchaseDescription, purchaseValue);
                card01.addPurchaseToList(purchase01);
                double actualLimit = card01.getLimit();
                double actualPurchase = purchase01.getPurchasePrice();

                card01.setLimit(actualLimit - actualPurchase);

                System.out.println("Limite após a compra é: " + card01.getLimit());

                while (oneOrZero != 0 && oneOrZero != 1) {
                    System.out.println("Para realizar uma nova compra digite 1 para sair do sistema digite 0.");
                    oneOrZero = input.nextInt();
                    if (oneOrZero == 1) {
                        continue;
                    } else if (oneOrZero == 0) {
                        System.out.println("COMPRAS REALIZADAS: ");
                        Collections.sort(card01.getPurchasesList());
                        for (Purchase c : card01.getPurchasesList()) {
                            System.out.println(c.getPurchaseName() + "-" + c.getPurchasePrice());
                        }
                        card01.setSystem(false);
                    } else {
                        System.out.println("Opção inválida, tente novamente");
                    }
                }
            }
        }
    }
}