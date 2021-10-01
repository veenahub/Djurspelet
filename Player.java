package com.example.djurspelet;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player {
    private String name;
    private float money;
    Store store = new Store();
    Animal animal;
    float animalPrice;
    ArrayList<Animal> UserAnimalList = new ArrayList<Animal>();
    public Player(String name,float money) {
        this.name = name;
        this.money = money;
    }
    public String getName() { return name;}
    public void chooseAnimal() {
        animal = store.buyAnimal();
        animalPrice = animal.getPrice();
        System.out.println(" your chosen animal price is : " + animalPrice );
        float RemainingMoney = (money - animalPrice);
        money = RemainingMoney;
        System.out.println("your Remaining amount " + money);
        UserAnimalList.add(animal);
    }
    public void userAnimalList() {
        System.out.println("your  animals list");
        for (Animal animal : UserAnimalList) {
            String userchoice = animal.getClass().getName();
            int length_of_the_string = userchoice.length();
            System.out.println( userchoice.substring(23,length_of_the_string));
        }
    }
    
    public Animal userAnimal(String animalType, String gender) {
        for (Animal animal : UserAnimalList) {
            String userchoice = animal.getName();
            if(animalType.equalsIgnoreCase(userchoice) && gender.equalsIgnoreCase(String.valueOf(animal.getGender()))) {
            	return animal;
            }
        }
        return null;
    }
    
    public boolean animalsToMate() {
        System.out.println("Animals that can mate:");
        Map<String,String> animalAndGenderMap = new HashMap<String, String>();
        boolean canAnimalsMate = false;
         
        for (Animal animal : UserAnimalList) {
            String userchoice = animal.getClass().getName();
         
            if(animalAndGenderMap.containsKey(userchoice)) {
            	String existingAnimalGender = animalAndGenderMap.get(userchoice);
            	if(!String.valueOf(animal.getGender()).equals(existingAnimalGender)){
            		int length_of_the_string = userchoice.length();
                    System.out.println( userchoice.substring(23,length_of_the_string));
                    canAnimalsMate = true;
            	}
            } else {
            	animalAndGenderMap.put(userchoice, String.valueOf(animal.getGender()));
            }
            
        }
        return canAnimalsMate;
    }
    public float getMoney() {
        return  money;
    }
	public void mateAnimals(String pet) {
		switch(pet) {
        case "dog" :
        	Dog maleDog = (Dog) userAnimal("Dog", "m");
        	Dog femaleDog =(Dog) userAnimal("Dog", "f");
        	Animal newdog = maleDog.mate(femaleDog);
        	if(newdog != null) {
                UserAnimalList.add(animal);
        	}
            break;
        case "cat" :
            Cat maleCat = (Cat) userAnimal("Cat", "m");
            Cat femaleCat =(Cat) userAnimal("Cat", "f");
            Animal newcat = maleCat.mate(femaleCat);
            if(newcat != null) {
                UserAnimalList.add(animal);
            }
             break;
        case "horse" :
            Horse maleHorse = (Horse) userAnimal("Horse", "m");
            Horse femaleHorse =(Horse) userAnimal("Horse", "f");
            Animal newhorse = maleHorse.mate(femaleHorse);
            if(newhorse != null) {
                UserAnimalList.add(animal);
            }
            break;
        case "rabbit" :
            Rabbit maleRabbit = (Rabbit) userAnimal("Rabbit", "m");
            Rabbit femaleRabbit =(Rabbit) userAnimal("Rabbit", "f");
            Animal newrabbit = maleRabbit.mate(femaleRabbit);
            if(newrabbit != null) {
                UserAnimalList.add(animal);
            }
            break;
        case "mouse" :
            Mouse maleMouse = (Mouse) userAnimal("Mouse", "m");
            Mouse femaleMouse =(Mouse) userAnimal("Mouse", "f");
            Animal newmouse = maleMouse.mate(femaleMouse);
            if(newmouse != null) {
                UserAnimalList.add(animal);
            }
            break;
        default :
            System.out.println("Please select animals from above list.");
    }
		
	}

}
