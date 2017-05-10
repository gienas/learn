import java.util.ArrayList;
import java.util.List;

public class TestExtendSuper {

  public static void main(String... strings) {

    List<Animal> animals = new ArrayList<>();
    List<Bird> birds = new ArrayList<>();
    List<Adler> adlers = new ArrayList<>();
    List<Swallow> swallow = new ArrayList<>();
    List<Object> objects = new ArrayList<>(); // possible object is super of Bird

    add1(birds);
    add1(adlers);
    add1(swallow);

    add2(animals);
    add2(birds);
    // add2(adlers); not possible, should be birds and lower ...
    // add2(swallow); not possible, should be birds and lower ..
    add2(objects);

    // another test
    birds.add(new Adler());

    // List<Bird> birds1 = adlers //not possible

    List<? extends Bird> birds2 = adlers;
    // adlers.add(new Bird()); //not possible;

  }

  public static void add1(List<? extends Bird> list) {
    Adler ad = new Adler();
    // list.add(ad); not possible because

  }

  public static void add2(List<? super Bird> list) {
    // call method with collection Bird and lower
    // add bird and higher ...
    // list.add(new Animal()); not possible Animal is not Bird
    list.add(new Bird());
    list.add(new Adler());
    list.add(new Swallow());
    // list.add();
  }

}

class Animal {

}

class Bird extends Animal {

}

class Adler extends Bird {

}

class Swallow extends Bird {

}
