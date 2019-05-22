package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static String fileName;


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String numeCarte;
        String userChoice;
        String parola = "";
        String tipCarte;
        String resumat;
        String username;
        boolean checkIfAlreadyAdded = false;
        boolean check = true;
        boolean check3 = true;
        boolean check4 = true;
        boolean check5 = true;
        List<Carti> listaCarti = new ArrayList<>();
        List<Persoana> listaUsers = new ArrayList<>();
        FileOutputStream fosUsers = new FileOutputStream("listUsers");
        ObjectOutputStream oosUsers= new ObjectOutputStream(fosUsers);

        System.out.println("-----Bine at venit la Biblioteca Stefan Cel Mare-----");
        Persoana userListInitializer = new Persoana("placeholder antani", "parola antani", 0);
        Persoana admin = new Persoana("admin", "admin", 0);
        listaUsers.add(admin);
        listaUsers.add(userListInitializer);
        Persoana user = new Persoana("something else ", null, 0);
        while (true) {
            check = true;
            while (check) {
                System.out.println("Tastati username ");
                username = sc.nextLine();
                if (!username.equalsIgnoreCase("admin")) {
                    for (int i = 0; i < listaUsers.size(); i++) {
                        if (!(username.equalsIgnoreCase(listaUsers.get(i).getUsername().toLowerCase()))) {
                            while (check5) {
                                System.out.println("Username not found, do you want to create a new user? \"Yes\" or \"No\". ");
                                userChoice = sc.nextLine().toLowerCase();
                                switch (userChoice) {
                                    case ("yes"):
                                        user.setUsername(username);
                                        while (true) {
                                            System.out.println("Type your password");
                                            String temporaryPassword = sc.nextLine().toLowerCase();
                                            if (temporaryPassword.equalsIgnoreCase(username) || temporaryPassword.equalsIgnoreCase("admin")) {
                                                System.out.println("Password cannot be the same as the Username, please choose a new password to proceed.");
                                                continue;
                                            }
                                            user.setParola(temporaryPassword);
                                            listaUsers.add(user);
                                            i = listaUsers.size();
                                            for (Persoana myUsers : listaUsers) {
                                                oosUsers.writeObject(myUsers);
                                            }
                                            check5 = false;
                                            break;
                                        }
                                        break;
                                    case ("no"):
                                        check5 = false;
                                        break;
                                    default:
                                        System.out.println("I said \"Yes\" or \"No\".");
                                        break;
                                }
                            }
                        } else {
                            userListInitializer = listaUsers.get(i);
                            System.out.println("Type your password");
                            parola = sc.nextLine().toLowerCase();
                            if (!parola.equals(userListInitializer.getParola())) {
                                System.out.println("Wrong password, try again.");
                            } else {
                                check = false;
                            }
                        }
                    }
                } else {
                    System.out.println("Type your password");
                    String temporaryPassword = sc.nextLine().toLowerCase();
                    if (!temporaryPassword.equalsIgnoreCase("admin")) {
                        break;
                    } else {
                        parola = temporaryPassword;
                        check = false;
                    }
                }
            }
            switch (parola) {
                case ("admin"):
                    System.out.println("-----Ati accesat interfata de introducere carti.-----");
                    while (!parola.equals("585486213873873887")) {
                        System.out.println("Tastati \"nou\" pentru a adauga o carte, \"listare\" pentru a afisa toate cartile sau \"exit\" pentru a iesi din interfata de introducere carti");
                        String userChoiceNowOrExit = sc.nextLine();
                        switch (userChoiceNowOrExit) {
                            case ("nou"):
                                Carti carte1 = new Carti(null, null, null, 0);
                                System.out.println("Introduceti numele cartii");
                                carte1.setNumeCarte(numeCarte = sc.nextLine().toLowerCase());
                                for (Carti aListaCarti : listaCarti) {
                                    if (aListaCarti.getNumeCarte().replaceAll("\\s+", "").equalsIgnoreCase(carte1.getNumeCarte().replaceAll("\\s+", ""))) {
                                        while (check4) {
                                            System.out.println("Exista deja o carte cu acelasi nume, tastati \"adauga\" pentru" + " a introduce o carte noua sau \"exit\" pentru a adauga inca un exemplar");
                                            String userChoiceDuplicateBook = sc.nextLine();
                                            switch (userChoiceDuplicateBook) {
                                                case ("adauga"):
                                                    aListaCarti.setContorCartiPerCarte(aListaCarti.getContorCartiPerCarte() + 1);
                                                    checkIfAlreadyAdded = true;
                                                    check4 = false;
                                                    break;
                                                case ("exit"):
                                                    checkIfAlreadyAdded = true;
                                                    check4 = false;
                                                    break;
                                                default:
                                                    System.out.println("Am zis \"adauga\" sau \"exit\"!");
                                                    break;
                                            }
                                        }
                                    }
                                }
                                if (!checkIfAlreadyAdded) {
                                    System.out.println("Introduceti tipul de carte");
                                    carte1.setTipCarte(tipCarte = sc.nextLine());
                                    System.out.println("Introduceti autorul si un scurt resumat");
                                    carte1.setResumat(resumat = sc.nextLine());
                                    carte1.setContorCartiPerCarte(1);
                                    listaCarti.add(carte1);
                                } else if (checkIfAlreadyAdded) {
                                    checkIfAlreadyAdded = false;
                                }
                                break;
                            case ("listare"):
                                for (Carti aListaCarti : listaCarti) {
                                    System.out.println(aListaCarti.toString());
                                }
                                break;
                            case ("exit"):
                                ObjectOutputStream oos = getOOS("bookList.txt");
                                System.out.println("---Serializare " + listaCarti.size() + " carti.---");
                                for (Carti myCarte : listaCarti) {
                                    oos.writeObject(myCarte);
                                }
                                oos.close();
                                parola = "585486213873873887";
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case ("finalexit"):
                    System.exit(0);
                default:
                    check = true;
                    while (check) {
                        Carti carte1 = new Carti("NumeCarteTest", "TipCarteTest", "RezumatCarteTest", 7);
                        listaCarti.add(carte1);

                        System.out.println("Tastati  \"Imprumut\" pentru a imprumuta o carte sau \"Retur\" pentru a returna sau \"Exit\" pentru a iesi.");
                        userChoice = sc.nextLine().toLowerCase().trim();
                        switch (userChoice) {
                            case ("imprumut"):
                                while (true) {
                                    System.out.println("Tastati numele carti pe care doriti sa imprumutati sau \"Exit\" pentru a iesi.");
                                    userChoice = sc.nextLine().toLowerCase().trim().replaceAll("\\s+", "");
                                    if (userChoice.equals("exit")) {
                                        break;
                                    }
                                    check = true;
                                    while (check) {
                                        for (Carti aListaCarti : listaCarti) {
                                            if (aListaCarti.getNumeCarte().trim().replaceAll("\\s+", "").equalsIgnoreCase(userChoice)) {
                                                if (aListaCarti.getContorCartiPerCarte() > 0) {
                                                    aListaCarti.setContorCartiPerCarte(aListaCarti.getContorCartiPerCarte() - 1);
                                                    ObjectOutputStream oos = getOOS("bookList.txt");
                                                    for (Carti myCarte : listaCarti) {
                                                        oos.writeObject(myCarte);
                                                    }
                                                    oos.close();
                                                    if(userListInitializer.getNumarCartiImprumutate() > 5) {
                                                        System.out.println("You can only borrow 5 books at a time");
                                                    } else {
                                                        userListInitializer.setNumarCartiImprumutate(+1);
                                                    }
                                                    for (Persoana myUsers : listaUsers) {
                                                        oosUsers.writeObject(myUsers);
                                                    }
                                                    user.addCarte(userChoice);
                                                    check = false;
                                                } else {
                                                    System.out.println("Nu mai sun exemplare disponibile.");
                                                    check = false;
                                                }
                                            } else {
                                                System.out.println("Momentan nu avem ace carte.");
                                                check = false;
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            case ("retur"):
                                System.out.println("Tastati numele carti pe care doriti sa returnati sau \"Exit\" pentru a iesi.");
                                userChoice = sc.nextLine().toLowerCase().trim().replaceAll("\\s+", "");
                                if (userChoice.equals("exit")) {
                                    break;
                                }
                                check = true;
                                while (check) {
                                    for (Carti aListaCarti : listaCarti) {
                                        if (aListaCarti.getNumeCarte().trim().replaceAll("\\s+", "").equalsIgnoreCase(userChoice)) {
                                            aListaCarti.setContorCartiPerCarte(aListaCarti.getContorCartiPerCarte() + 1);
                                            ObjectOutputStream oos = getOOS("bookList.txt");
                                            for (Carti myCarte : listaCarti) {
                                                oos.writeObject(myCarte);
                                            }
                                            oos.close();
                                            user.removeCarte(aListaCarti.getNumeCarte());
                                            check = false;
                                        } else {
                                            System.out.println("Nu exista o carte cu numelele tastat, mai incercati sau tastati \"Exit\" pentru a iesi.");
                                            userChoice = sc.nextLine();
                                            if (userChoice.equalsIgnoreCase("exit")) {
                                                check = false;
                                                check3 = false;
                                                break;
                                            }
                                        }
                                    }
                                }
                                break;
                            case ("exit"):
                                check = false;
                                check5 = true;
                                break;
                            default:
                                System.out.println("Am zis  \"Imprumut\", \"Retur\" sau \"Exit\"! ");
                        }
                    }
                    break;

            }
        }

    }

    private static ObjectOutputStream getOOS(String fileName) throws IOException {
        Main.fileName = fileName;
        boolean append = false;

        File f = new File(fileName);

        if (f.exists()) {
            append = true;
        }

        FileOutputStream fos = new FileOutputStream(f, true);
        ObjectOutputStream oos = null;

        if (append) {
            oos = new AppendingObjectOutputStream(fos);
        } else {
            oos = new ObjectOutputStream(fos);
        }

        return oos;
    }
}
