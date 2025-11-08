import tester.*; // The tester library
import javalib.worldimages.*; // images, like RectangleImage or OverlayImages
import javalib.funworld.*; // the abstract World class and the big-bang library
import java.awt.Color; // general colors (as triples of red,green,blue values)
import java.util.Random; // and predefined colors (Red, Green, Yellow, Blue, Black, White)

//interface of ILoWord
interface ILoWord {

  //returns an integer based on where the active word is
  int activeXPos() ;

  // returns a scene with all of the words from a list
  WorldScene draw(WorldScene ws);

  // returns a new ILoWord of this ILoWord without empty words
  ILoWord filterEmptyList();

  // takes in a letter as a String and produces a list with
  // the matching first letters as the given removed
  ILoWord checkAndReduce(String letter);

  // changes the y value of active words in the list,
  // makes more words, and updates the level
  ILoWord onTick();

  // create a new list with the given word added in
  public ILoWord createList(IWord word);

  // returns true if this IWord's y value is the same as the height
  boolean isGameOver();

  // returns true if there is an inactive word’s first letter
  // that matches the given string
  boolean checkScore(String letter);

  // checks if there is an active in the list and returns true
  boolean isActiveInList();

  // makes a new list where the input is taken off the active word if they match
  ILoWord reduceActive(String letter);

  // returns a list where the input is taken off the active word if there is an active 
  ILoWord activeCheckReduce(String key);

  // returns a boolean if there is an active word that has the same first letter as the inputed word
  boolean activeScoreChecker(String key);

  // creates a new list so the level and press tab message are shown
  ILoWord listWithLevel(IWord word);

  // returns a boolean based on gameOverCheckHelper2
  boolean checkGameHelper();

  // returns a boolean based on gameOverCheckHelp if the y is the same as scene height
  boolean checkGameHelper2();

  // returns the rest of the rest of the list
  ILoWord listWithLevelHelp();

  // returns boolean if the second item is a LevelWord
  boolean listWithLevelHelp2();

}

interface IWord {
  // screen height constant
  int SCENE_HEIGHT = 400;

  // font size constant
  int FONT_SIZE = 25;

  // takes away the first letter of the string if it matches the input letter
  IWord reduce(String letter);

  // checks if a word is empty
  boolean filterHelp();

  // returns a scene with all of the words from a list are displayed
  WorldScene draw(WorldScene ws);

  // changes the y value of active words in the list,
  // makes more words, and updates the level
  IWord onTick();

  //returns a boolean if the first letter of an inactive word is the same as input
  boolean reduceHelper(String letter);

  //returns a boolean if the y value of the word is the same as scene height
  boolean isGameOverHelper();

  //checks if a word is active
  boolean checkActiveWord();

  //takes first letter off a word and makes it active
  IWord activeReducer(String letter);

  //checks if an active word has the same first letter as input
  boolean activeLetterChecker(String letter);

  //returns the x value of an active word or half scene width
  int activeWordX();

  //checks if the input word is a LevelWord
  boolean checkWordLevel();

}

class MtLoWord implements ILoWord {

  /*
   * TEMPLATE
   * 
   * FIELDS
   * NONE
   * 
   * METHODS
   * this.checkAndReduce(String letter) ... ILoWord
   * this.filterEmptyList() ... ILoWord
   * this.draw(WorldScene ws) ... WorldScene
   * this.onTick()...ILoWord
   * this.createList(IWord word) ... ILoWord
   * this.isGameOver() ... boolean
   * this.checkScore(String Letter) ... boolean
   * this.isActiveInList() ... boolean
   * this.reduceActive(String Letter) ... ILoWord
   * this.activeCheckReduce(String key) ... ILoWord
   * this.activeScoreChecker(String key) ... ILoWord
   * this.listWithLevel(IWord word) ... ILoWord
   * this.activeXPos() ... int
   * this.listWithLevelHelp() ... ILoWord
   * this.listWithLevelHelp2() ... boolean
   * this.checkGameHelper() ... boolean
   * this.checkGameHelper2() ... boolean
   */

  // returns a scene with all of the words from a list
  public WorldScene draw(WorldScene ws) {
    return ws;
  }

  // produces an ILoWord where empty IWords are filtered
  public ILoWord filterEmptyList() {
    return this;
  }

  // takes in a letter as a String and produces a list with
  // the matching first letters as the given removed
  public ILoWord checkAndReduce(String letter) {
    return this;
  }

  // changes the y value of active words in the list,
  // makes more words, and updates the level
  public ILoWord onTick() {
    return this;
  }

  // create a new list with the given word added in
  public ILoWord createList(IWord word) {
    return new ConsLoWord(word, new MtLoWord());
  }

  // returns true if this IWord's y value is the same as the height
  public boolean isGameOver() {
    return false;
  }

  // returns true if there is an inactive word’s first letter
  // that matches the given string
  public boolean checkScore(String letter) {
    return false;
  }

  //checks if there is an active in the list and returns true
  public boolean isActiveInList() {
    return false;
  }

  //makes a new list where the input is taken off the active word if they match
  public ILoWord reduceActive(String letter) {
    return new MtLoWord();
  }

  //returns a list where the input is taken off the active word if there is an active 
  public ILoWord activeCheckReduce(String key) {
    return new MtLoWord();
  }

  //returns a boolean if there is an active word that has the same first letter as the input
  public boolean activeScoreChecker(String key) {
    return false;
  }

  //creates a new list so the level and press tab message are displayed
  public ILoWord listWithLevel(IWord word) {
    return new ConsLoWord(word, new MtLoWord());
  }

  //returns an integer based on where the active word is or if 
  //there is none the middle of the screen
  public int activeXPos() {
    return 200;
  }

  //returns the rest of the rest of the list
  public ILoWord listWithLevelHelp() {
    return new MtLoWord();
  }

  //returns boolean if the second item is a LevelWord
  public boolean listWithLevelHelp2() {
    return false;
  }

  //returns a boolean based on gameOverCheckHelper2
  public boolean checkGameHelper() {
    return false;
  }

  //returns a boolean based on gameOverCheckHelp if the y is the same as scene height
  public boolean checkGameHelper2() {
    return false;
  }

}

class ConsLoWord implements ILoWord {
  IWord first;
  ILoWord rest;

  ConsLoWord(IWord first, ILoWord rest) {
    this.first = first;
    this.rest = rest;
  }

  /*
   * TEMPLATE
   * FIELDS
   * this.first ... IWord
   * this.rest ... ILoWord
   * METHODS
   * this.checkAndReduce(String letter) ... ILoWord
   * this.filterEmptyList() ... ILoWord
   * this.draw(WorldScene ws) ... WorldScene
   * this.onTick()... ILoWord
   * this.createList(IWord word) ... ILoWord
   * this.isGameOver() ... boolean
   * this.checkScore(String Letter) ... boolean
   * this.isActiveInList() ... boolean
   * this.reduceActive(String Letter) ... ILoWord
   * this.activeCheckReduce(String key) ... ILoWord
   * this.activeScoreChecker(String key) ... ILoWord
   * this.listWithLevel(IWord word) ... ILoWord
   * this.activeXPos() ... int
   * this.listWithLevelHelp() ... ILoWord
   * this.listWithLevelHelp2() ... boolean
   * this.checkGameHelper() ... boolean
   * this.checkGameHelper2() ... boolean
   * METHODS OF FIELDS
   * this.rest.checkAndReduce(String letter) ... ILoWord
   * this.rest.filterEmptyList() ... ILoWord
   * this.rest.draw(WorldScene ws) ... WorldScene
   * this.rest.onTick()... ILoWord
   * this.rest.createList(IWord word) ... ILoWord
   * this.rest.isGameOver() ... boolean
   * this.rest.checkScore(String Letter) ... boolean
   * this.rest.isActiveInList() ... boolean
   * this.rest.reduceActive(String Letter) ... ILoWord
   * this.rest.activeCheckReduce(String key) ... ILoWord
   * this.rest.activeScoreChecker(String key) ... ILoWord
   * this.rest.listWithLevel(IWord word) ... ILoWord
   * this.rest.activeXPos() ... int
   * this.rest.listWithLevelHelp() ... ILoWord
   * this.rest.listWithLevelHelp2() ... boolean
   * this.rest.checkGameHelper() ... boolean
   * this.rest.checkGameHelper2() ... boolean
   */

  // returns a scene with all of the words from a list
  public WorldScene draw(WorldScene ws) {
    return this.rest.draw(this.first.draw(ws));
  }

  // produces an ILoWord where empty IWords are filtered
  public ILoWord filterEmptyList() {
    if (this.first.filterHelp()) {
      return this.rest.filterEmptyList();
    } else {
      return new ConsLoWord(this.first, this.rest.filterEmptyList());
    }
  }

  // takes in a letter as a String and produces a list with
  // the matching first letters as the given removed
  public ILoWord checkAndReduce(String letter) {
    if (this.first.reduceHelper(letter)) {
      return new ConsLoWord(this.first.reduce(letter), this.rest); 
    } else {
      return new ConsLoWord(this.first, this.rest.checkAndReduce(letter));
    }
  }

  // changes the y value of active words in the list,
  // makes more words, and updates the level
  public ILoWord onTick() {
    return new ConsLoWord(this.first.onTick(), this.rest.onTick());
  }

  // create a new list with the given word added in
  public ILoWord createList(IWord word) {
    return new ConsLoWord(this.first, this.rest.createList(word));
  }

  // returns true if this IWord's y value is the same as the height
  public boolean isGameOver() {
    return this.rest.checkGameHelper();
  }

  //returns a boolean based on gameOverCheckHelper2
  public boolean checkGameHelper() {
    return this.rest.checkGameHelper2();
  }

  //returns a boolean based on gameOverCheckHelp if the y is the same as scene height
  public boolean checkGameHelper2() {
    return this.first.isGameOverHelper();
  }

  //returns a boolean if there is an active word that has the same first letter as the input
  public boolean activeScoreChecker(String letter) {
    if (this.first.activeLetterChecker(letter)) {
      return true;
    } else {
      return this.rest.activeScoreChecker(letter);
    }
  }

  // returns true if there is an inactive word’s first letter
  // that matches the given string
  public boolean checkScore(String letter) {
    if (this.first.reduceHelper(letter)) {
      return true;
    } else {
      return this.rest.checkScore(letter);
    }
  }

  //returns a list where the input is erased from the active word if there is an active 
  public ILoWord activeCheckReduce(String letter) {
    if (this.isActiveInList()) {
      return reduceActive(letter);
    } else {
      return this.checkAndReduce(letter);
    }
  }

  //checks if there is an active in the list and returns true
  public boolean isActiveInList() {
    return (this.first.checkActiveWord() || this.rest.isActiveInList());
  }

  //makes a new list where the input is erased from the active word if they match
  public ILoWord reduceActive(String letter) {
    return new ConsLoWord(this.first.activeReducer(letter), this.rest.reduceActive(letter));
  }

  //creates a new list so the level and press tab message are displayed
  public ILoWord listWithLevel(IWord word) {
    if (this.first.checkWordLevel() && this.rest.listWithLevelHelp2()) {

      IWord pressTab = new LevelWord("tab to restart", 300, 520, 0.75);

      return new ConsLoWord(word, new ConsLoWord(pressTab, this.rest.listWithLevelHelp()));
    } if (this.first.checkWordLevel()) {

      IWord pressTab = new LevelWord("tab to restart", 300, 520, 0.75);

      return new ConsLoWord(word, new ConsLoWord(pressTab, this.rest));
    } else {

      IWord pressTab = new LevelWord("tab to restart", 300, 520, 0.75);

      return new ConsLoWord(word, new ConsLoWord(pressTab, this));
    }
  }

  //returns the rest of the rest of list
  public ILoWord listWithLevelHelp() {
    return this.rest;
  }

  //returns boolean if the second item is a LevelWord
  public boolean listWithLevelHelp2() {
    return (this.first.checkWordLevel());
  }

  //returns an integer based on where the active word is
  public int activeXPos() {
    if (this.first.activeWordX() >= 0) {
      return this.first.activeWordX();
    } else {
      return this.rest.activeXPos();
    }
  }
}

// Represents an Abstract Word Class 
abstract class AWord implements IWord {
  String word;
  int x;
  int y;

  AWord(String word, int x, int y) {
    this.word = word;
    this.x = x;
    this.y = y;
  }

  AWord(String word, int x) {
    this.word = word;
    this.x = x;
    this.y = SCENE_HEIGHT;
  }

  /*
   * TEMPLATE
   * METHODS
   * this.filterHelp() ... boolean
   * this.reduce(String letter) ... IWord
   * this.reduceHelper(String Letter) ... boolean
   * this.isGameOverHelper() ... boolean
   * this.checkActiveWord() ... boolean
   * this.activeReducer(String letter) ... IWord
   * this.activeLetterChecker(String letter) ... boolean
   * this.activeWordX() ... int
   * this.checkWordLevel() ... boolean
   * METHODS OF FIELDS
   * this.word.filterHelp() ... boolean
   * this.word.reduce(String letter) ... IWord
   * this.word.reduceHelper(String Letter) ... boolean
   * this.word.isGameOverHelper() ... boolean
   * this.word.checkActiveWord() ... boolean
   * this.word.activeReducer(String letter) ... IWord
   * this.word.activeLetterChecker(String letter) ... boolean
   * this.word.activeWordX() ... int
   * this.word.checkWordLevel() ... boolean
   * this.x.filterHelp() ... boolean
   * this.x.reduce(String letter) ... IWord
   * this.x.reduceHelper(String Letter) ... boolean
   * this.x.isGameOverHelper() ... boolean
   * this.x.checkActiveWord() ... boolean
   * this.x.activeReducer(String letter) ... IWord
   * this.x.activeLetterChecker(String letter) ... boolean
   * this.x.activeWordX() ... int
   * this.x.checkWordLevel() ... boolean
   * this.y.filterHelp() ... boolean
   * this.y.reduce(String letter) ... IWord
   * this.y.reduceHelper(String Letter) ... boolean
   * this.y.isGameOverHelper() ... boolean
   * this.y.checkActiveWord() ... boolean
   * this.y.activeReducer(String letter) ... IWord
   * this.y.activeLetterChecker(String letter) ... boolean
   * this.y.activeWordX() ... int
   * this.y.checkWordLevel() ... boolean
   */

  // returns a scene with all of the words from a list
  public abstract WorldScene draw(WorldScene w);

  // checks if a word is empty
  public boolean filterHelp() {
    return this.word.equals("");
  }

  // takes away the first letter of the string if it matches the input
  public IWord reduce(String letter) {
    if (this.word.startsWith(letter)) {
      return new ActiveWord(this.word.substring(1), this.x, this.y);
    } else {
      return this;
    }
  }

  //returns a boolean if the first letter of an inactive word is the same as input
  public boolean reduceHelper(String letter) {
    return (this.word.startsWith(letter));
  }

  //returns a boolean if the y value of the word is the same as scene height
  public boolean isGameOverHelper() {
    return this.y == SCENE_HEIGHT;
  }

  //checks if a word is actve
  public boolean checkActiveWord() {
    return false;
  }

  //takes first letter off a word and makes it active
  public IWord activeReducer(String letter) {
    return this;
  }

  //checks if an active word has the same first letter as inpu
  public boolean activeLetterChecker(String letter) {
    return false;
  }

  //returns the x value of an active word or half scene width
  public int activeWordX() {
    return -1;
  }

  //checks if the input is a LevelWord
  public boolean checkWordLevel() {
    return false;
  }

}

class LevelWord extends AWord {

  double size;
  
  LevelWord(String word, int x, int y, double size) {

    super(word, x, y);
    this.size = size;
  }

  /*
   * TEMPLATE
   * FIELDS
   * this.size ... double
   * 
   * METHODS
   * this.filterHelp() ... boolean
   * this.reduceHelp(String letter) ... boolean
   * this.draw(WorldScene ws) ... WorldScene
   * this.onTick()... IWord
   * 
   * METHODS OF FIELDS
   * this.word.filterHelp() ... boolean
   * this.word.reduceHelper(String letter) ... boolean
   * this.word.draw(WorldScene ws) ... WorldScene
   * this.word.onTick()... IWord
   * this.x.filterHelp() ... boolean
   * this.x.reduceHelper(String letter) ... boolean
   * this.x.draw(WorldScene ws) ... WorldScene
   * this.x.onTick()... IWord
   * this.y.filterHelp() ... boolean
   * this.y.reduceHelper(String letter) ... boolean
   * this.y.draw(WorldScene ws) ... WorldScene
   * this.y.onTick()... IWord
   * this.size.filterHelp() ... boolean
   * this.size.reduceHelper(String letter) ... boolean
   * this.size.draw(WorldScene ws) ... WorldScene
   * this.size.onTick()... IWord
   */

  // checks if a word is empty
  public boolean filterHelp() {
    return false;
  }

  // changes the y value of active words in the list,
  // makes more words, and updates the level
  public IWord onTick() {
    return this;
  }

  //returns a boolean if the first letter of an inactive word is the same as inpu
  public boolean reduceHelper(String letter) {
    return false;
  }

  // returns a scene with all of the words from a list
  public WorldScene draw(WorldScene ws) {
    return ws.placeImageXY(new TextImage(this.word, FONT_SIZE * size,
        FontStyle.BOLD, Color.black), this.x, this.y);
  }

  //checks if the input word is a LevelWord
  public boolean checkWordLevel() {
    return true;
  }
}

// Represents Active Words in a ZType game
class ActiveWord extends AWord {

  ActiveWord(String word, int x, int y) {
    super(word, x, y);
  }

  /*
   * TEMPLATE
   * FIELDS
   * none
   * 
   * METHODS
   * this.reduce(String letter) ... IWord
   * this.activeChcker() ... boolean
   * this.draw(WorldScene ws) ... WorldScene
   * this.onTick()... IWord
   * this.activeReducer(String letter) ... IWord
   * this.activeLetterChecker(String letter) ... boolean
   * this.activeWordX() ... int
   * 
   * METHODS OF FIELDS
   * this.word.reduce(String letter) ... IWord
   * this.word.activeChcker() ... boolean
   * this.word.draw(WorldScene ws) ... WorldScene
   * this.word.onTick()... IWord
   * this.word.activeReducer(String letter) ... IWord
   * this.word.activeLetterChecker(String letter) ... boolean
   * this.word.activeWordX() ... int
   * this.x.size.onTick()... IWord
   * this.x.reduce(String letter) ... IWord
   * this.x.activeChcker() ... boolean
   * this.x.draw(WorldScene ws) ... WorldScene
   * this.x.onTick()... IWord
   * this.x.activeReducer(String letter) ... IWord
   * this.x.activeLetterChecker(String letter) ... boolean
   * this.x.activeWordX() ... int
   * this.y.size.onTick()... IWord
   * this.y.reduce(String letter) ... IWord
   * this.y.activeChcker() ... boolean
   * this.y.draw(WorldScene ws) ... WorldScene
   * this.y.onTick()... IWord
   * this.y.activeReducer(String letter) ... IWord
   * this.y.activeLetterChecker(String letter) ... boolean
   * this.y.activeWordX() ... int
   * this.y.size.onTick()... IWord
   */

  // takes away the first letter of the string if it matches the input
  public IWord reduce(String letter) {
    if (this.word.startsWith(letter)) {
      return new ActiveWord(this.word.substring(1), this.x, this.y);
    } else {
      return this;
    }
  }

  // returns scene with all of the words from a list
  public WorldScene draw(WorldScene ws) {
    return ws.placeImageXY(new TextImage(this.word, FONT_SIZE,
        FontStyle.REGULAR, Color.blue), this.x, this.y);
  }

  // changes the y value of active words in the list,
  // makes more words, and updates the level
  public IWord onTick() {
    return new ActiveWord(word, x, y + 1);    
  }

  //checks if a word is active
  public boolean checkActiveWord() {
    return true;
  }

  //takes first letter off word and makes it active
  public IWord activeReducer(String letter) {
    if (this.word.startsWith(letter)) {
      return new ActiveWord(this.word.substring(1), this.x, this.y);
    } else {
      return this;
    }
  }

  //checks if active word has same first letter as input
  public boolean activeLetterChecker(String letter) {
    return this.word.startsWith(letter);
  }

  //returns x value of  active word or half scene width
  public int activeWordX() {
    return this.x;
  }

}

// Represents Inactive Words in a ZType game
class InactiveWord extends AWord {

  InactiveWord(String word, int x, int y) {
    super(word, x, y);
  }

  /*
   * TEMPLATE
   * METHODS
   * this.draw(WorldScene ws) ... WorldScene
   * this.onTick()... IWord
   * 
   * METHODS OF FIELDS
   * this.word.draw(WorldScene ws) ... WorldScene
   * this.word.onTick()... IWord
   * this.x.draw(WorldScene ws) ... WorldScene
   * this.x.onTick()... IWord
   * this.y.draw(WorldScene ws) ... WorldScene
   * this.y.onTick()... IWord
   */

  // returns a scene with all of the words from a list are displayed
  public WorldScene draw(WorldScene ws) {
    return ws.placeImageXY(new TextImage(this.word, FONT_SIZE, FontStyle.REGULAR,
        Color.blue), this.x, this.y);
  }

  // changes the y value of active words in the list,
  // makes more words, and updates the level
  public IWord onTick() {
    return new InactiveWord(word, x, y + 1);    
  }

}

// Represents a ZType Game
class ZTypeWorld extends World {
  ILoWord words;
  int ticks;
  int score;
  Random rand;
  Random rand2;


  ZTypeWorld(ILoWord words, int ticks, int score, Random rand, Random rand2) {
    this.words = words;
    this.ticks = ticks;
    this.score = score;
    this.rand = rand;
    this.rand2 = rand2;
  }

  ZTypeWorld(ILoWord words, int ticks, int score) {
    this(words, ticks, score, new Random(), new Random());
  }



  /*
   * TEMPLATE
   * FIELDS
   * this.words ... ILoWord
   * this.ticks ... int
   * this.score ... int
   * this.rand ... Random
   * this.rand2 ... Random
   * 
   * METHODS
   * this.makeScene() ...  WorldScene
   * this.onTick() ... World
   * this.levelFinder() ... IWord
   * this.levelWorldScene() ... WorldScene
   * this.levelChecker() ... int
   * this.onKeyEvent(String key) ... World
   * this.lastScene(String str) ... WorldScene
   * 
   * METHODS OF FIELDS
   * this.words.makeScene() ... WorldScene
   * this.words.onTick() ... World
   * this.words.levelFinder() ... IWord
   * this.words.levelWorldScene() ... WorldScene
   * this.words.levelChecker() ... int
   * this.words.onKeyEvent(String key) ... World
   * this.words.lastScene(String str) ... WorldScene
   * this.ticks.makeScene() ... WorldScene
   * this.ticks.onTick() ... World
   * this.ticks.levelFinder() ... IWord
   * this.ticks.levelWorldScene() ... WorldScene
   * this.ticks.levelChecker() ... int
   * this.ticks.onKeyEvent(String key) ... World
   * this.ticks.lastScene(String str) ... WorldScene
   * this.score.makeScene() ... WorldScene
   * this.score.onTick() ... World
   * this.score.levelFinder() ... IWord
   * this.score.levelWorldScene() ... WorldScene
   * this.score.levelChecker() ... int
   * this.score.onKeyEvent(String key) ... World
   * this.score.lastScene(String str) ... WorldScene
   * this.rand.makeScene() ... WorldScene
   * this.rand.onTick() ... World
   * this.rand.levelFinder() ... IWord
   * this.rand.levelWorldScene() ... WorldScene
   * this.rand.levelChecker() ... int
   * this.rand.onKeyEvent(String key) ...  World
   * this.rand.lastScene(String str) ... WorldScene
   * this.rand2.makeScene() ...  WorldScene
   * this.rand2.onTick() ... World
   * this.rand2.levelFinder() ... IWord
   * this.rand2.levelWorldScene() ... WorldScene
   * this.rand2.levelChecker() ... int
   * this.rand2.onKeyEvent(String key) ... World
   * this.rand2.lastScene(String str) ... WorldScene
   */

  // creates the scene for the game
  public WorldScene makeScene() {
    WorldScene scene = this.levelWorldScene().placeImageXY(new EquilateralTriangleImage(15,
        OutlineMode.OUTLINE, Color.red), this.words.activeXPos(), 590)
        .placeImageXY(new EquilateralTriangleImage(13,
            OutlineMode.SOLID, Color.white), this.words.activeXPos(), 590);
    return this.words.draw(scene);
  }
  
  // changes the y value of active words in the list,
  // makes more words, and updates the level
  public World onTick() {
    if (this.words.isGameOver()) {
      return endOfWorld("WOMP WOMP GAME OVER! ");
    }

    if (this.ticks % this.levelChecker() == 0) {

      IWord newWord = new InactiveWord(new Utils(rand).callAcc(), 
          (this.rand2.nextInt(300)) + 50, 0);
      ILoWord newWords = this.words.createList(newWord);
      ILoWord level = newWords.listWithLevel(this.levelFinder());

      return new ZTypeWorld(level.onTick(), ticks + 1, score);
    } else {
      return new ZTypeWorld(this.words.onTick(), ticks + 1, score);
    }
  }


  //checks if the score is less than a certain number
  public IWord levelFinder() {
    if (this.score < 100) {
      return new LevelWord("LEVEL 1", 300, 500, 1.5) ; } 
    if (this.score < 200) {
      return new LevelWord("LEVEL 2", 300, 500, 1.5) ; } 
    if (this.score < 300) {
      return new LevelWord("LEVEL 3", 300, 500, 1.5) ; } 
    if (this.score < 400) {
      return new LevelWord("LEVEL 4", 300, 500, 1.5) ; } 
    if (this.score < 500) {
      return new LevelWord("LEVEL 5", 300, 500, 1.5) ; } 
    if (this.score < 600) {
      return new LevelWord("LEVEL 6", 300, 500, 1.5) ; } 
    if (this.score < 700) {
      return new LevelWord("LEVEL 7", 300, 500, 1.5) ; } 
    if (this.score < 800) {
      return new LevelWord("LEVEL 8", 300, 500, 1.5) ; } 
    if (this.score < 900) {
      return new LevelWord("LEVEL 9", 300, 500, 1.5) ; } 
    else {
      return new LevelWord("FINAL LEVEL", 300, 500, 1.5) ; } 

  }

  //changes the scene for diff level
  public WorldScene levelWorldScene() {
    if (this.score < 100) {
      return new WorldScene(400, 600).placeImageXY(
          new RectangleImage(400, 600, OutlineMode.SOLID, Color.white), 200, 300); } 
    if (this.score < 200) {
      return new WorldScene(400, 600).placeImageXY(
          new RectangleImage(400, 600, OutlineMode.SOLID, Color.white), 200, 300); } 
    if (this.score < 300) {
      return new WorldScene(400, 600).placeImageXY(
          new RectangleImage(400, 600, OutlineMode.SOLID, Color.red), 200, 300); } 
    if (this.score < 400) {
      return new WorldScene(400, 600).placeImageXY(
          new RectangleImage(400, 600, OutlineMode.SOLID, Color.red), 200, 300); } 
    if (this.score < 500) {
      return new WorldScene(400, 600).placeImageXY(
          new RectangleImage(400, 600, OutlineMode.SOLID, Color.green), 200, 300); } 
    if (this.score < 600) {
      return new WorldScene(400, 600).placeImageXY(
          new RectangleImage(400, 600, OutlineMode.SOLID, Color.green), 200, 300); } 
    if (this.score < 700) {
      return new WorldScene(400, 600).placeImageXY(
          new RectangleImage(400, 600, OutlineMode.SOLID, Color.yellow), 200, 300); } 
    if (this.score < 800) {
      return new WorldScene(400, 600).placeImageXY(
          new RectangleImage(400, 600, OutlineMode.SOLID, Color.yellow), 200, 300); } 
    if (this.score < 900) {
      return new WorldScene(400, 600).placeImageXY(
          new RectangleImage(400, 600, OutlineMode.SOLID, Color.black), 200, 300); } 
    else {
      return new WorldScene(400, 600).placeImageXY(
          new RectangleImage(400, 600, OutlineMode.SOLID, Color.black), 200, 300); } 

  }


  //checks level user is on
  public int levelChecker() {
    if (this.score < 100) { 
      return 100 ; } 
    if (this.score < 200) { 
      return 90 ; } 
    if (this.score < 300) { 
      return 80 ; } 
    if (this.score < 400) { 
      return 70 ; } 
    if (this.score < 500) { 
      return 60 ; } 
    if (this.score < 600) { 
      return 50 ; } 
    if (this.score < 700) { 
      return 45 ; } 
    if (this.score < 800) { 
      return 40 ; } 
    if (this.score < 900) { 
      return 35 ; } 
    else { 
      return 30 ; } 

  }

  //takes in a key event and runs if statement
  public World onKeyEvent(String key) {
    if (key.equals("tab")) {
      return new ZTypeWorld(new MtLoWord(), 0, 0);
    }
    if (this.words.activeScoreChecker(key)) {
      return new ZTypeWorld(this.words.activeCheckReduce(key).filterEmptyList(), 
          ticks, score + 10);
    }
    if (this.words.checkScore(key) && !this.words.isActiveInList()) {
      return new ZTypeWorld(this.words.activeCheckReduce(key).filterEmptyList(), 
          ticks, score + 10);
    } else {
      return new ZTypeWorld(this.words.activeCheckReduce(key).filterEmptyList(), ticks, score);
    }
  }

  //dsiplays the game over scene
  public WorldScene lastScene(String str) {
    return new WorldScene(400, 600)
        .placeImageXY(new TextImage(str, 25, FontStyle.REGULAR, Color.black),
            400 / 2, 600 / 2);
  }

}

// Represents a class of Util methods
class Utils {
  Random rand;

  Utils(Random rand) {
    this.rand = rand;
  }

  Utils() {
    this(new Random());
  }

  /*
   * TEMPLATE
   * FIELDS
   * this.rand ... Random
   * 
   * METHODS
   * this.numToString(int num) ... String
   * this.stringAcc(String str, int num, int topend) ... String
   * this.callAcc() ... String
   * this.makeInt(int) ... int
   * 
   * METHODS OF FIELDS
   * this.rand.numToString ... String
   * this.rand.stringAcc ... String
   * this.rand.callAcc ... String
   * this.rand.makeInt(int) ... int
   */

  // converts the latter to a corresponding number in the alphabet string
  String numToString(int num) {
    return "abcdefghijklmnopqrstuvwxyz".substring(num, num + 1);
  }

  // accumulates the length of the string so that it creates a string of 6 letters
  String stringAcc(String str, int num, int topend) {
    if (num >= 0 && num < topend) {
      return (str + stringAcc(numToString(this.rand.nextInt(26)), num + 1, topend));
    } else {
      return str;
    }
  }

  // calls stringAcc to create a string of 6 letters
  String callAcc() {
    return stringAcc("", 0, (this.rand.nextInt(6) + 4));
  }

  int makeInt() {
    return (this.rand.nextInt(300)) + 50;
  }
}

class ExamplesZType {

  Random rand;

  ExamplesZType() {
    this(new Random());
  }

  ExamplesZType(Random rand) {
    this.rand = rand;
  }

  IWord random = new InactiveWord(new Utils(new Random(75)).callAcc(), 
      (new Utils(new Random(75)).makeInt()), 1);

  IWord end = new ActiveWord("coffee", 20, 600);

  ILoWord mt = new MtLoWord();


  ILoWord endList = new ConsLoWord(this.end, 
      new ConsLoWord(this.coffeeA, this.mt));
  IWord coffeeI = new InactiveWord("coffee", 3, 4);
  IWord coffeeA = new ActiveWord("coffee", 2, 2);
  IWord coffeeACase = new ActiveWord("Coffee", 2, 4);
  ILoWord list1 = new ConsLoWord(this.coffeeA, this.mt);

  IWord sodaA = new ActiveWord("soda", 3, 4);
  ILoWord list2 = new ConsLoWord(this.sodaA,
      new ConsLoWord(this.coffeeA, this.mt));

  ILoWord sortedList2 = new ConsLoWord(this.coffeeA, new ConsLoWord(this.sodaA, this.mt));
  IWord lemonadeI = new InactiveWord("lemonade", 1, 2);
  ILoWord list3 = new ConsLoWord(this.lemonadeI,
      new ConsLoWord(this.sodaA,
          new ConsLoWord(this.coffeeA, this.mt)));

  ILoWord listInactive = new ConsLoWord(this.lemonadeI,
      new ConsLoWord(this.water, this.mt));

  IWord water = new InactiveWord("water", 3, 4);

  ILoWord sortedList = new ConsLoWord(this.coffeeA,
      new ConsLoWord(this.lemonadeI,
          new ConsLoWord(this.sodaA, this.mt)));

  IWord mtWord = new ActiveWord("", 3, 4);
  ILoWord mtList = new ConsLoWord(this.mtWord, this.list3);

  ILoWord twoSameList = new ConsLoWord(this.sodaA,
      new ConsLoWord(this.sodaA, this.list1));

  IWord caseSoda = new ActiveWord("Soda", 5, 6);
  ILoWord caseList = new ConsLoWord(this.caseSoda, this.list2);

  ILoWord mtOnlyList = new ConsLoWord(this.mtWord,
      new ConsLoWord(this.mtWord, this.mt));

  ILoWord edgeCaseList = new ConsLoWord(this.coffeeA, new ConsLoWord(this.coffeeI,
      new ConsLoWord(this.coffeeACase, new ConsLoWord(this.sodaA,
          new ConsLoWord(this.lemonadeI, new ConsLoWord(this.mtWord,
              new ConsLoWord(this.mtWord, this.mt)))))));

  ILoWord edgeCaseListSorted = new ConsLoWord(this.mtWord, new ConsLoWord(this.mtWord,
      new ConsLoWord(this.coffeeA, new ConsLoWord(this.coffeeI,
          new ConsLoWord(this.coffeeACase, new ConsLoWord(this.lemonadeI,
              new ConsLoWord(this.sodaA, this.mt)))))));

  IWord a = new ActiveWord("a", 5, 6);
  ILoWord listA = new ConsLoWord(this.a, this.mt);

  AWord finalMessage = new InactiveWord("Womp Womp Game Over!", 400 / 2, 600 / 2);

  AWord word1 = new InactiveWord("jujuaf", 100, 1);
  AWord word2 = new InactiveWord("huyyyee", 2, 3);
  AWord word3 = new InactiveWord("yipeee", 5, 5);
  AWord word4 = new InactiveWord("bomboo", 6, 1);

  AWord word5 = new InactiveWord("abcghe", 2, 9);
  AWord word6 = new InactiveWord("ffffff", 3, 8);
  AWord word7 = new InactiveWord("yooooo", 4, 7);
  AWord word8 = new InactiveWord("jkjkjk", 5, 6);

  ILoWord emtpy = new MtLoWord();

  ILoWord list1a = new ConsLoWord(this.word1, this.mt);

  ILoWord list2a = new ConsLoWord(this.word2, new ConsLoWord(this.word4,
      new ConsLoWord(this.word3, new MtLoWord())));

  ILoWord list3a = new ConsLoWord(this.word5, new ConsLoWord(this.word6, new ConsLoWord(this.word7,
      new ConsLoWord(this.word8, new MtLoWord()))));

  ILoWord list4 = new ConsLoWord(this.word7, new ConsLoWord(this.word8, new MtLoWord()));

  ILoWord list1rand = new ConsLoWord(new ActiveWord("coffee", 2, 3), 
      new ConsLoWord(this.random, this.mt));



  WorldScene ws1 = new WorldScene(400, 600);

  ZTypeWorld mtWorld = new ZTypeWorld(this.mt, 0, 300);

  ZTypeWorld list1World = new ZTypeWorld(this.list1, 0, 0, (new Random(75)), (new Random(75)));

  ZTypeWorld randWorld = new ZTypeWorld(this.list1rand, 0, 0, (new Random(75)), (new Random(75)));

  ILoWord overList1 = new ConsLoWord(new InactiveWord("coffee", 400, 600), new MtLoWord());
  ILoWord overList2 = new ConsLoWord(new ActiveWord("coffee", 4, 2), new MtLoWord());
  ILoWord overList3 = new ConsLoWord(new LevelWord("coffee", 400, 600, 0.5), new MtLoWord());

  ILoWord listWithLevel1 = new ConsLoWord(new LevelWord("level 1", 0 , 0, 0.5), 
      new ConsLoWord(coffeeA, new MtLoWord()));

  ILoWord listWithLevel2 = new ConsLoWord(new LevelWord("level 1", 0 , 0, 0.5), 
      new ConsLoWord(new ActiveWord("coffee", 400, 600), new MtLoWord()));

  ILoWord listWithLevel3 = new ConsLoWord(new LevelWord("level 1", 0 , 0, 0.5), 
      new ConsLoWord(new InactiveWord("coffee", 400, 600), new MtLoWord()));

  boolean testNumToString(Tester t) {
    return t.checkExpect(new Utils(new Random(0)).numToString(0), "a")
        &&
        t.checkExpect(new Utils(new Random(7)).numToString(7), "h")
        &&
        t.checkExpect(new Utils(new Random(4)).numToString(4), "e");
  }

  boolean testStringAcc(Tester t) {
    return t.checkExpect(new Utils(new Random(0)).stringAcc("", 0, 6), "ssxvnj")

        && t.checkExpect(new Utils(new Random(4)).stringAcc("agdp", 4, 6), "agdpdqs")

        && t.checkExpect(new Utils(new Random(2)).stringAcc("xy", 2, 6), "xysgdav")

        && t.checkExpect(new Utils(new Random(75)).stringAcc("hola", 4, 6), "holdamm")

        && t.checkExpect(new Utils(new Random(1234567890)).stringAcc("", 0, 6), "dsfdcpi");
  }

  boolean testCallAcc(Tester t) {
    return t.checkExpect(new Utils(new Random(10)).callAcc(), "glyesfm")
        && t.checkExpect(new Utils(new Random(25)).callAcc(), "yzezakzjqo")
        && t.checkExpect(new Utils(new Random(2)).callAcc(), "gavareizn")
        && t.checkExpect(new Utils(new Random(3)).callAcc(), "mmhqauv")
        && t.checkExpect(new Utils(new Random(75)).callAcc(), "mvamv")
        && t.checkExpect(new Utils(new Random(1234567890)).callAcc(), "sfcapipc");  
  }

  boolean testBigBang(Tester t) {

    ZTypeWorld world = new ZTypeWorld(this.mt, 0, 0);
    return world.bigBang(400, 600, 0.03);

  }

  boolean testListMaker(Tester t) {
    return
        t.checkExpect(this.list1.createList(coffeeA),
            new ConsLoWord(this.coffeeA, new ConsLoWord(this.coffeeA,
                this.mt)))
        &&
        t.checkExpect(this.list2.createList(lemonadeI),
            new ConsLoWord(this.sodaA, new ConsLoWord(this.coffeeA,
                new ConsLoWord(this.lemonadeI, this.mt))))
        &&
        t.checkExpect(this.list3.createList(water), 
            new ConsLoWord(this.lemonadeI,
                new ConsLoWord(this.sodaA,
                    new ConsLoWord(this.coffeeA,
                        new ConsLoWord(this.water, this.mt)))))
        &&
        t.checkExpect(this.mtOnlyList.createList(coffeeI), 
            new ConsLoWord(this.mtWord,
                new ConsLoWord(this.mtWord,
                    new ConsLoWord(this.coffeeI, this.mt))));
  }

  boolean testCheckAndReduce(Tester t) {
    return 
        t.checkExpect(this.list3.checkAndReduce("a"), this.list3)
        &&
        t.checkExpect(this.list3.checkAndReduce("c"), 
            new ConsLoWord(this.lemonadeI, new ConsLoWord(this.sodaA, 
                new ConsLoWord(new ActiveWord("offee", 2, 2), this.mt))))
        &&
        t.checkExpect(this.list2.checkAndReduce("s"), 
            new ConsLoWord(new ActiveWord("oda", 3, 4), 
                new ConsLoWord(this.coffeeA, this.mt)))
        &&
        t.checkExpect(this.twoSameList.checkAndReduce("s"), 
            new ConsLoWord(new ActiveWord("oda", 3, 4), 
                new ConsLoWord(new ActiveWord("soda", 3, 4), this.list1)))
        &&

        t.checkExpect(this.edgeCaseList.checkAndReduce("c"), 
            new ConsLoWord(new ActiveWord("offee", 2, 2), new ConsLoWord(this.coffeeI, 
                new ConsLoWord(this.coffeeACase, new ConsLoWord(this.sodaA, 
                    new ConsLoWord(this.lemonadeI, new ConsLoWord(this.mtWord, 
                        new ConsLoWord(this.mtWord, this.mt))))))))
        &&
        t.checkExpect(this.listA.checkAndReduce("a"), 
            new ConsLoWord(new ActiveWord("", 5, 6), this.mt))
        &&
        t.checkExpect(this.mtOnlyList.checkAndReduce("a"), this.mtOnlyList)
        &&
        t.checkExpect(this.edgeCaseList.checkAndReduce("C"), 
            new ConsLoWord(this.coffeeA, new ConsLoWord(this.coffeeI, 
                new ConsLoWord(new ActiveWord("offee", 2, 4), new ConsLoWord(this.sodaA, 
                    new ConsLoWord(this.lemonadeI, new ConsLoWord(this.mtWord, 
                        new ConsLoWord(this.mtWord, this.mt))))))));
  }
  
  //checks for active words in list
  boolean testGameOverCheckHelp(Tester t) {
    return 
        t.checkExpect(this.coffeeA.isGameOverHelper(), false)
        &&
        t.checkExpect(this.end.isGameOverHelper(), false);
  }

  //checks lists for words
  boolean testGameOverCheck(Tester t) {
    return 
        t.checkExpect(this.list2.isGameOver(), false)
        &&
        t.checkExpect(this.endList.isGameOver(), false);
  }

  boolean testScoreChecker(Tester t) {
    return 
        t.checkExpect(this.list3.checkScore("a"), false)
        &&
        t.checkExpect(this.list3.checkScore("c"), true);
  }

  boolean testActiveListChecker(Tester t) {
    return 
        t.checkExpect(this.list2.isActiveInList(), true)
        &&
        t.checkExpect(this.mtOnlyList.isActiveInList(), true);
  }

  boolean testReduceActive(Tester t) {
    return 
        t.checkExpect(this.list2.reduceActive("s"), 
            new ConsLoWord(new ActiveWord("oda", 3, 4),
                new ConsLoWord(this.coffeeA, this.mt)))
        &&

        t.checkExpect(this.list3.reduceActive("r"), 
            new ConsLoWord(this.lemonadeI,
                new ConsLoWord(this.sodaA,
                    new ConsLoWord(this.coffeeA, this.mt))));
  }

  boolean testCheckActiveAndReduce(Tester t) {
    return 
        t.checkExpect(this.list2.activeCheckReduce("s"), 
            new ConsLoWord(new ActiveWord("oda", 3, 4),
                new ConsLoWord(this.coffeeA, this.mt)))
        &&

        t.checkExpect(this.list3.activeCheckReduce("r"), 
            new ConsLoWord(this.lemonadeI,
                new ConsLoWord(this.sodaA,
                    new ConsLoWord(this.coffeeA, this.mt))));
  }

  
  //checks for empty strings
  boolean testFilterHelp(Tester t) {
    return
        t.checkExpect(this.mtWord.filterHelp(), true)
        &&
        t.checkExpect(this.coffeeA.filterHelp(), false);
  }

  //test the filter function
  boolean testFilterEmpties(Tester t) {
    return 
        t.checkExpect(this.mtList.filterEmptyList(), new ConsLoWord(this.lemonadeI, 
            new ConsLoWord(this.sodaA, new ConsLoWord(this.coffeeA, this.mt))))
        &&
        t.checkExpect(this.list3.filterEmptyList(), this.list3)
        &&
        t.checkExpect(this.list2.filterEmptyList(), this.list2)
        &&
        t.checkExpect(this.sortedList.filterEmptyList(), this.sortedList)
        &&
        t.checkExpect(this.mtOnlyList.filterEmptyList(), this.mt)
        &&
        t.checkExpect(this.edgeCaseList.filterEmptyList(), 
            new ConsLoWord(this.coffeeA, new ConsLoWord(this.coffeeI, 
                new ConsLoWord(this.coffeeACase, new ConsLoWord(this.sodaA, 
                    new ConsLoWord(this.lemonadeI, this.mt))))));
  }

  //tests for active score
  boolean testActiveScoreChecker(Tester t) {
    return 
        t.checkExpect(this.list2.activeScoreChecker("c"), true)
        &&
        t.checkExpect(this.list2.activeScoreChecker("g"), false);
  }

  //test for a level word
  boolean testLevelWordChecker(Tester t) {
    return t.checkExpect(new LevelWord("hola", 0, 0, 0.5).checkWordLevel(), true)
        && t.checkExpect(new InactiveWord("awfjfawjn", 1, 2).checkWordLevel(), false)
        && t.checkExpect(new ActiveWord("awdaf", 7, 3).checkWordLevel(), false);
  }

  //tsting thje reduce helper function
  boolean testReduceHelper(Tester t) {
    return 
        t.checkExpect(this.coffeeA.reduceHelper("c"), true)
        &&
        t.checkExpect(this.coffeeA.reduceHelper("t"), false)
        &&
        t.checkExpect(this.mtWord.reduceHelper("d"), false);
  }

  //testing active and inactive
  boolean testActiveChecker(Tester t) {
    return 
        t.checkExpect(this.coffeeA.checkActiveWord(), true)
        &&
        t.checkExpect(this.lemonadeI.checkActiveWord(), false);
  }

  //testing an active word and if it reduces
  boolean testActiveReducer(Tester t) {
    return 
        t.checkExpect(this.coffeeA.activeReducer("c"), 
            new ActiveWord("offee", 2 ,2))
        &&
        t.checkExpect(this.lemonadeI.activeReducer("c"), this.lemonadeI)
        &&
        t.checkExpect(this.lemonadeI.activeReducer("r"), this.lemonadeI);
  }

  //checking for active letters
  boolean testActiveLetterChecker(Tester t) {
    return 
        t.checkExpect(this.coffeeA.activeLetterChecker("c"), true)
        &&
        t.checkExpect(this.coffeeA.activeLetterChecker("a"), false)
        &&
        t.checkExpect(this.lemonadeI.activeLetterChecker("r"), false)
        &&
        t.checkExpect(this.lemonadeI.activeLetterChecker("t"), false);
  }

  //testing is an active list for acgive and inactive words
  boolean testActiveListX(Tester t) {
    return 
        t.checkExpect(this.list2.activeXPos(), 3)
        &&
        t.checkExpect(this.list3.activeXPos(), 3);
  }

  //test if a word is active or inactive
  boolean testActiveWordX(Tester t) {
    return 
        t.checkExpect(this.coffeeA.activeWordX(), 2)
        &&
        t.checkExpect(this.lemonadeI.activeWordX(), -1);
  }

  boolean testLevelList(Tester t) {
    return 
        t.checkExpect(this.list2.listWithLevel(this.coffeeA), 
            new ConsLoWord(this.coffeeA, new ConsLoWord(
                new LevelWord("Press tab to restart", 300, 520, .75), 
                new ConsLoWord(this.sodaA,
                    new ConsLoWord(this.coffeeA, this.mt)))))
        &&
        t.checkExpect(this.list1.listWithLevel(this.sodaA), 
            new ConsLoWord(this.sodaA, new ConsLoWord(
                new LevelWord("Press tab to restart", 300, 520, .75), 
                new ConsLoWord(this.coffeeA, this.mt))));
  }

  boolean testLevelFinder(Tester t) {
    return 
        t.checkExpect(this.mtWorld.levelFinder(), 
            new LevelWord("LEVEL 4", 300, 500, 1.5))
        &&
        t.checkExpect(this.list1World.levelFinder(), 
            new LevelWord("LEVEL 1", 300, 500, 1.5));
  }

  boolean testLevelWorldScene(Tester t) {
    return t.checkExpect(this.mtWorld.levelFinder(),  
            new LevelWord("LEVEL 4", 300, 500, 1.5))
        && t.checkExpect(this.list1World.levelFinder(), 
            new LevelWord("LEVEL 1", 300, 500, 1.5));
  }

  // test levelChecker
  boolean testLevelChecker(Tester t) {
    return t.checkExpect(this.mtWorld.levelChecker(), 70)
        && t.checkExpect(this.list1World.levelChecker(), 100);
  }

  // test onKeyEvent
  boolean testOnKeyEvent(Tester t) {
    return t.checkExpect(this.mtWorld.onKeyEvent("a"), 
            new ZTypeWorld(this.mt, 0, 300))
        &&
        t.checkExpect(this.list1World.onKeyEvent("c"), 
            new ZTypeWorld(new ConsLoWord(
                new ActiveWord("offee", 2, 2), this.mt), 0, 10));
  }

  // test lastScene
  boolean testLastScene(Tester t) {
    return t.checkExpect(this.list1World.lastScene("ads"), 
            new WorldScene(400, 600).placeImageXY(
                new TextImage("ads", 25, FontStyle.REGULAR, Color.black),
                400 / 2, 600 / 2))
        &&
        t.checkExpect(this.mtWorld.lastScene("asdv"), 
            new WorldScene(400, 600).placeImageXY(
                new TextImage("asdv", 25, FontStyle.REGULAR, Color.black),
                400 / 2, 600 / 2));
  }

  // test onTick
  boolean testOnTick(Tester t) {
    return t.checkExpect(this.list1World.onTick(), 
            new ZTypeWorld(new ConsLoWord(new LevelWord("LEVEL 1", 300, 500, 1.5), 
                new ConsLoWord(new LevelWord("Press tab to restart", 300, 520, .75),
                    this.list1rand)), 1, 0));
  }

  // test makeScene
  boolean testMakeScene(Tester t) {
    return t.checkExpect(this.mtWorld.makeScene(), new WorldScene(400, 600)
            .placeImageXY(new RectangleImage(400, 600, OutlineMode.SOLID, Color.cyan), 200, 300)
            .placeImageXY(new EquilateralTriangleImage(15,
                OutlineMode.OUTLINE, Color.red), 200, 590).placeImageXY(
                    new EquilateralTriangleImage(13,
                        OutlineMode.SOLID, Color.white), 200, 590));
  }

  //test checkGameHelper
  boolean testGameOverCheckHelper1(Tester t) {
    return t.checkExpect(this.listWithLevel1.checkGameHelper(), false)
        && t.checkExpect(this.listWithLevel2.checkGameHelper(), false)
        && t.checkExpect(this.listWithLevel3.checkGameHelper(), false);
  }

  //test checkGameHelper2
  boolean testGameOverCheckHelper2(Tester t) {
    return t.checkExpect(this.overList1.checkGameHelper2(), false)
        && t.checkExpect(this.overList2.checkGameHelper2(), false)
        && t.checkExpect(this.overList3.checkGameHelper2(), false);
  }
  // test listWithLevelHelp
  boolean testLevelListHelp(Tester t) {
    return t.checkExpect(this.list3.listWithLevelHelp(),new ConsLoWord(this.sodaA,
        new ConsLoWord(this.coffeeA, this.mt)))
        && t.checkExpect(this.list2.listWithLevelHelp(), new ConsLoWord(this.coffeeA, this.mt))
        && t.checkExpect(this.mt.listWithLevelHelp(), new MtLoWord());
  }

  //test listWithLevelHelp2
  boolean testLevelListHelp2(Tester t) {
    return t.checkExpect(this.list3.listWithLevelHelp2(), false)
        && t.checkExpect(new ConsLoWord(new LevelWord("jlaskjdlas", 1, 2, 0.5), 
            new MtLoWord()).listWithLevelHelp2(), true)
        && t.checkExpect(this.mt.listWithLevelHelp2(), false);
  }
  
  //test for levelword
  boolean testReduce(Tester t) {
    return t.checkExpect(new LevelWord("hi", 0, 0, 0.5).reduce("h"), 
            (new ActiveWord("i", 0, 0)))
        && t.checkExpect(new InactiveWord("jlaskjdlas", 1, 2).reduce("h"), 
            (new InactiveWord("jlaskjdlas", 1, 2)))
        && t.checkExpect(new InactiveWord("jlaskjdlas", 1, 2).reduce("a"), 
            (new InactiveWord("jlaskjdlas", 1, 2)))
        && t.checkExpect(new ActiveWord("awdvaf", 7, 3).reduce("h"), 
            (new ActiveWord("awdaf", 7, 3)))
        && t.checkExpect(new ActiveWord("awdvaf", 7, 3).reduce("a"), 
            (new ActiveWord("wdaf", 7, 3)))
        && t.checkExpect(this.mtWord, new ActiveWord("", 3, 4));
  }

  // test draw
  boolean testDraw(Tester t) {
    return t.checkExpect(this.list3.draw(ws1), new WorldScene(400, 600)
            .placeImageXY(new TextImage("lemonade", 20, FontStyle.REGULAR, Color.gray), 1, 2)
            .placeImageXY(new TextImage("soda", 20, FontStyle.REGULAR, Color.orange), 3, 4)
            .placeImageXY(new TextImage("coffee", 20, FontStyle.REGULAR, Color.orange), 2, 2));
  }
}