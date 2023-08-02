package care_fragments.quiz;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import care_fragments.quiz.QuizContract.*;

import java.util.ArrayList;
import java.util.List;


public class QuizDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "CareQuizDatabase.db";
    private static final int DATABASE_VERSION = 1;

    private static QuizDbHelper instance;

    private SQLiteDatabase db;

    private QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized QuizDbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new QuizDbHelper(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_CATEGORIES_TABLE = "CREATE TABLE " +
                CategoriesTable.TABLE_NAME + "( " +
                CategoriesTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CategoriesTable.COLUMN_NAME + " TEXT " +
                ")";

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionsTable.COLUMN_DIFFICULTY + " TEXT, " +
                QuestionsTable.COLUMN_CATEGORY_ID + " INTEGER, " +
                "FOREIGN KEY(" + QuestionsTable.COLUMN_CATEGORY_ID + ") REFERENCES " +
                CategoriesTable.TABLE_NAME + "(" + CategoriesTable._ID + ")" + "ON DELETE CASCADE" +
                ")";

        db.execSQL(SQL_CREATE_CATEGORIES_TABLE);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillCategoriesTable();
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CategoriesTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    private void fillCategoriesTable() {
        Category c1 = new Category("JAVA");
        insertCategory(c1);
        Category c2 = new Category("PYTHON");
        insertCategory(c2);
        Category c3 = new Category("Csharp");
        insertCategory(c3);
    }

    public void addCategory(Category category) {
        db = getWritableDatabase();
        insertCategory(category);
    }

    public void addCategories(List<Category> categories) {
        db = getWritableDatabase();

        for (Category category : categories) {
            insertCategory(category);
        }
    }

    private void insertCategory(Category category) {
        ContentValues cv = new ContentValues();
        cv.put(CategoriesTable.COLUMN_NAME, category.getName());
        db.insert(CategoriesTable.TABLE_NAME, null, cv);
    }

    private void fillQuestionsTable() {
        //---------------------------JAVA EASY---------------------------
        Question java_easy_q1 = new Question("In Java, every application must contain a main method as the entry point.",
                "True", "False", "Free","Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q1);

        Question java_easy_q2 = new Question("Java supports multiple inheritance, allowing a class to extend multiple classes.",
                "True", "False", "Free","Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q2);

        Question java_easy_q3 = new Question("The break statement is used to exit from a loop prematurely.",
                "True", "False", "Free","Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q3);

        Question java_easy_q4 = new Question("In Java, the String class is mutable, meaning its value can be changed after creation.",
                "True", "False", "Free","Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q4);

        Question java_easy_q5 = new Question("The NullPointerException is a checked exception in Java.",
                "True", "False", "Free","Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q5);

        Question java_easy_q6 = new Question("The && operator in Java is a logical OR operator.",
                "True", "False", "Free","Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q6);

        Question java_easy_q7 = new Question("An interface in Java can have method implementations.",
                "True", "False", "Free","Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q7);

        Question java_easy_q8 = new Question("The ArrayList class in Java is a resizable array implementation.",
                "True", "False", "Free","Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q8);

        Question java_easy_q9 = new Question("The final keyword in Java is used to declare constant variables that cannot be modified.",
                "True", "False", "Free","Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q9);

        Question java_easy_q10 = new Question("The equals() method in Java compares the memory addresses of two objects.",
                "True", "False", "Free","Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q10);

        Question java_easy_q11 = new Question("The do-while loop in Java always executes its code block at least once.",
                "True", "False", "Free","Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q11);

        Question java_easy_q12 = new Question("Java allows direct memory manipulation through pointers.",
                "True", "False", "Free","Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q12);

        Question java_easy_q13= new Question("The Math.random() method in Java returns a random number between 0 (inclusive) and 1 (exclusive).",
                "True", "False", "Free","Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q13);

        Question java_easy_q14 = new Question("The StringBuilder class in Java is mutable and used for creating modifiable strings.",
                "True", "False", "Free","Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q14);

        Question java_easy_q15 = new Question("The super keyword in Java is used to call the superclass's constructor.",
                "True", "False", "Free","Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q15);

        Question java_easy_q16 = new Question("The instance of operator in Java is used to check if an object is an instance of a specific class or its subclasses.",
                "True", "False", "Free","Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q16);

        Question java_easy_q17 = new Question("A try block in Java must always be followed by a catch block.",
                "True", "False", "Free","Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q17);

        Question java_easy_q18 = new Question("The switch statement in Java can only be used with int and char data types.",
                "True", "False", "Free","Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q18);

        Question java_easy_q19 = new Question("Java has a built-in pair class to store two values together.",
                "True", "False", "Free","Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q19);

        Question java_easy_q20 = new Question("The NullPointerException occurs when a program attempts to access a member of a null object.",
                "True", "False", "Free","Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q20);

        //--------------------------JAVA MEDIUM------------------------------
        Question java_medium_q1 = new Question("What is Java?",
                "A web browser", "An operating system", "A programming language","Free", 3,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q1);

        Question java_medium_q2 = new Question("Which of the following is not a Java primitive data type?",
                "int", "double", "String","Free", 3,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q2);

        Question java_medium_q3 = new Question("Which keyword is used to define a class in Java?",
                "class", "public", "void","Free", 1,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q3);

        Question java_medium_q4 = new Question("What is the purpose of the ‘main’ method in a Java program?",
                "It is the entry point of the program.", "It is used to declare variables.", "It is used to define constructors.","Free", 1,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q4);

        Question java_medium_q5 = new Question("Which operator is used for logical AND in Java?",
                "&&", "||", "&","Free", 1,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q5);

        Question java_medium_q6 = new Question("What is the purpose of the ‘import’ statement in Java?",
                "To import external libraries", "To enable multi-threading", "To access the internet","Free", 1,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q6);

        Question java_medium_q7 = new Question("Which access modifier makes a method or variable accessible only within its own class?",
                "public", "private", "protected","Free", 2,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q7);

        Question java_medium_q8 = new Question("What is the correct syntax to write a single-line comment in Java?",
                "// This is a comment", "/* This is a comment */", "' This is a comment’","Free", 1,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q8);

        Question java_medium_q9 = new Question("What is the purpose of the break statement in Java?",
                "To exit a loop or switch statement prematurely.", "To end the program execution.", "To throw an exception.","-------", 1,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q9);

        Question java_medium_q10 = new Question("Which of the following is NOT a core principle of Object-Oriented Programming (OOP)?",
                "Inheritance", "Modularity", "Polymorphism","Free", 2,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q10);

        Question java_medium_q11 = new Question("Which loop is guaranteed to execute at least once in Java?",
                "for loop", "while loop", "do-while loop","Free", 3,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q11);

        Question java_medium_q12 = new Question("Which Java keyword is used to inherit a class?",
                "extend", "implements", "extends","Free", 3,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q12);

        Question java_medium_q13 = new Question("Which keyword is used to create an object of a class in Java?",
                "create", "build", "new","Free", 3,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q13);

        Question java_medium_q14 = new Question("In Java, arrays are indexed starting from:",
                "0", "1", "-1","Free", 1,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q14);

        Question java_medium_q15 = new Question("Which operator is used for inequality comparison in Java?",
                "!=", "<>", "==","Free", 1,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q15);

        Question java_medium_q16 = new Question("What is the range of the char data type in Java?",
                "-128 to 127", "'\\u0000' to '\\uffff'", "-32768 to 32767","Free", 2,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q16);

        Question java_medium_q17 = new Question("Which method is automatically called when an object is garbage collected in Java?",
                "finalize()", "delete()", "remove()","Free", 1,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q17);

        Question java_medium_q18 = new Question("Which keyword is used to handle exceptions in Java?",
                "handle", "try", "catch","Free", 3,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q18);

        Question java_medium_q19 = new Question("How many \"else\" statements can be used with a single \"if\" statement?",
                "Only one", "As many as needed", "Two","Free", 1,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q19);

        Question java_medium_q20 = new Question("Which operator is used to compare two values for equality in Java?",
                "==", "=", "!=","Free", 1,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q20);

        //--------------------------JAVA Hard------------------------------
        Question java_hard_q1 = new Question("To declare a constant variable of type String with the name MESSAGE and assign it the value \"Hello\":\n" +
                "\n" +
                "_____ String MESSAGE = \"Hello\";¬\n",
                "Inherit", "String", "Boolean","final ", 4,
                Question.DIFFICULTY_HARD, Category.JAVA);
        insertQuestion(java_hard_q1);

        Question java_hard_q2 = new Question("To define a method named calculateArea that takes two parameters of type double for length and width, and returns their product:\n" +
                "\n" +
                "double calculateArea(double length, ______) {\n" +
                "    return length * width;\n" +
                "}\n",
                "Duration", "double", "Integer","Number", 2,
                Question.DIFFICULTY_HARD, Category.JAVA);
        insertQuestion(java_hard_q2);

        Question java_hard_q3 = new Question("To create a new instance of the ArrayList class that stores Integer objects:\n" +
                "\n" +
                "ArrayList<Integer> numbers = new ________<>();\n",
                "Array List", "arrayList", "arraylist","ArrayList", 4,
                Question.DIFFICULTY_HARD, Category.JAVA);
        insertQuestion(java_hard_q3);

        Question java_hard_q4 = new Question("To declare a variable age and initialize it with the value 25:\n" +
                "\n" +
                "int ______ = 25;\n",
                "age", "oldest", "young","eldest", 1,
                Question.DIFFICULTY_HARD, Category.JAVA);
        insertQuestion(java_hard_q4);

        Question java_hard_q5 = new Question("To define a method named getFullName that takes two parameters of type String for firstName and lastName, and returns their concatenation:\n" +
                "\n" +
                "String getFullName(String firstName, ________) {\n" +
                "    return firstName + lastName;\n" +
                "}\n",
                "Operators", "Void", "String","Methods", 3,
                Question.DIFFICULTY_HARD, Category.JAVA);
        insertQuestion(java_hard_q5);

        Question java_hard_q6 = new Question("To import the Scanner class from the java.util package:\n" +
                "\n" +
                "import _________;\n",
                "Scanner.util.java", "java.util.Scanner", "java.util.scanner","Java.Util.Scan", 2,
                Question.DIFFICULTY_HARD, Category.JAVA);
        insertQuestion(java_hard_q6);

        Question java_hard_q7 = new Question("To create a new instance of the Random class:\n" +
                "\n" +
                "Random random = new ________();\n",
                "handling", "Objects", "Classes","Random", 4,
                Question.DIFFICULTY_HARD, Category.JAVA);
        insertQuestion(java_hard_q7);

        Question java_hard_q8 = new Question("To define a do-while loop that continues as long as the variable count is greater than 0:\n" +
                "\n" +
                "do {\n" +
                "    // Loop body\n" +
                "} while (______ > 0);\n",
                "double", "random", "View","count", 4,
                Question.DIFFICULTY_HARD, Category.JAVA);
        insertQuestion(java_hard_q8);

        Question java_hard_q9 = new Question("To access the element at index 3 in the scores array:\n" +
                "\n" +
                "int value = scores[______];\n",
                "4", "3", "1","2", 2,
                Question.DIFFICULTY_HARD, Category.JAVA);
        insertQuestion(java_hard_q9);

        Question java_hard_q10 = new Question("To declare a variable pi and assign it the value 3.14159 with a data type that represents floating-point numbers:\n" +
                "\n" +
                "______ = 3.14159;\n",
                "boolean", "char", "double","int", 3,
                Question.DIFFICULTY_HARD, Category.JAVA);
        insertQuestion(java_hard_q10);

        Question java_hard_q11 = new Question("To define a method named calculateSum that takes a variable number of int arguments and returns their sum:\n" +
                "\n" +
                "int calculateSum(int... ________) {\n" +
                "    // Implementation code here\n" +
                "}\n",
                "Scene", "model", "numbers","controller", 3,
                Question.DIFFICULTY_HARD, Category.JAVA);
        insertQuestion(java_hard_q11);

        Question java_hard_q12 = new Question("To create a new instance of the HashSet class that stores String objects:\n" +
                "\n" +
                "HashSet<String> names = new ________<>();\n",
                "Hash_Set", "hashset", "HashSet","Hash.Set", 3,
                Question.DIFFICULTY_HARD, Category.JAVA);
        insertQuestion(java_hard_q12);

        Question java_hard_q13 = new Question("To define a switch statement that checks the value of the variable day:\n" +
                "\n" +
                "switch (______) {\n" +
                "    // Cases and code here\n" +
                "}\n",
                "day", "tuesday", "time","days", 1,
                Question.DIFFICULTY_HARD, Category.JAVA);
        insertQuestion(java_hard_q13);

        Question java_hard_q14 = new Question("To create a new instance of the LinkedList class that stores String objects:\n" +
                "\n" +
                "LinkedList<String> items = new ________<>();\n",
                "ArrayList", "ArrayElement", "ArrayLength","LinkedList", 4,
                Question.DIFFICULTY_HARD, Category.JAVA);
        insertQuestion(java_hard_q14);

        Question java_hard_q15 = new Question("To declare a variable isFound and initialize it with the value false:\n" +
                "boolean ______ = false;\n",
                "isfound", "IsFound", "isFound","Is Found", 3,
                Question.DIFFICULTY_HARD, Category.JAVA);
        insertQuestion(java_hard_q15);

        Question java_hard_q16 = new Question("To define a method named calculateAverage that takes an array of double as a parameter and returns their average:\n" +
                "\n" +
                "double calculateAverage(double[] ______) {\n" +
                "    // Implementation code here\n" +
                "}\n",
                "char", "values", "boolean","average", 2,
                Question.DIFFICULTY_HARD, Category.JAVA);
        insertQuestion(java_hard_q16);

        Question java_hard_q17 = new Question("To import the Arrays class from the java.util package:\n" +
                "import _________;\n",
                "java.util.array", "java.util.Arrays", "Java.Util.Arrays","Array.Java.Util", 2,
                Question.DIFFICULTY_HARD, Category.JAVA);
        insertQuestion(java_hard_q17);

        Question java_hard_q18 = new Question("To Fill in the blank to create a new instance of the HashMap class that stores String keys and Integer values:\n" +
                "\n" +
                "HashMap<String, ________> data = new HashMap<>();\n",
                "Integer", "float", "string","boolean", 1,
                Question.DIFFICULTY_HARD, Category.JAVA);
        insertQuestion(java_hard_q18);

        Question java_hard_q19 = new Question("To define a method named reverseString that takes a parameter of type String and returns its reverse:\n" +
                "\n" +
                "String reverseString(String ________) {\n" +
                "    // Implementation code here\n" +
                "}\n",
                "text", "int", "float","string", 1,
                Question.DIFFICULTY_HARD, Category.JAVA);
        insertQuestion(java_hard_q19);

        Question java_hard_q20 = new Question("To create a new instance of the StringBuilder class:\n" +
                "\n" +
                "StringBuilder sb = new ________();\n",
                "SB", "sb", "stringbuilder","StringBuilder", 4,
                Question.DIFFICULTY_HARD, Category.JAVA);
        insertQuestion(java_hard_q20);




        //-----------------------------------------Python Easy--------------------------------------------------

        Question python_easy_q1 = new Question(
                "In Python, you can use the if statement to execute a block of code only if a certain condition is true.",
                "True",
                "False",
                "Free",
                "Free",
                1,
                Question.DIFFICULTY_EASY,
                Category.PYTHON
        );

        insertQuestion(python_easy_q1);
// Question 2
        Question python_easy_q2 = new Question(
                "Python is a compiled language.",
                "True",
                "False",
                "Free",
                "Free",
                2,
                Question.DIFFICULTY_EASY,
                Category.PYTHON
        );
        insertQuestion(python_easy_q2);

// Question 3
        Question python_easy_q3 = new Question(
                "A Python list can contain elements of different data types.",
                "True",
                "False",
                "Free",
                "Free",
                1,
                Question.DIFFICULTY_EASY,
                Category.PYTHON
        );
        insertQuestion(python_easy_q3);

// Question 4
        Question python_easy_q4 = new Question(
                "Python uses curly braces ({}) to define blocks of code.",
                "True",
                "False",
                "Free",
                "Free",
                2,
                Question.DIFFICULTY_EASY,
                Category.PYTHON
        );
        insertQuestion(python_easy_q4);
// Question 5
        Question python_easy_q5 = new Question(
                "The elif keyword is used in Python for exception handling.",
                "True",
                "False",
                "Free",
                "Free",
                2,
                Question.DIFFICULTY_EASY,
                Category.PYTHON
        );
        insertQuestion(python_easy_q5);
// Question 6
        Question python_easy_q6 = new Question(
                "The range() function in Python generates a list of numbers.",
                "True",
                "False",
                "Free",
                "Free",
                2,
                Question.DIFFICULTY_EASY,
                Category.PYTHON
        );
        insertQuestion(python_easy_q6);
// Question 7
        Question python_easy_q7 = new Question(
                "Python is an object-oriented programming (OOP) language.",
                "True",
                "False",
                "Free",
                "Free",
                1,
                Question.DIFFICULTY_EASY,
                Category.PYTHON
        );
        insertQuestion(python_easy_q7);
// Question 8
        Question python_easy_q8 = new Question(
                "The append() method can be used to add an element to a Python dictionary.",
                "True",
                "False",
                "Free",
                "Free",
                2,
                Question.DIFFICULTY_EASY,
                Category.PYTHON
        );
        insertQuestion(python_easy_q8);
// Question 9
        Question python_easy_q9 = new Question(
                "The len() function in Python can be used to find the length of a string.",
                "True",
                "False",
                "Free",
                "Free",
                1,
                Question.DIFFICULTY_EASY,
                Category.PYTHON
        );
        insertQuestion(python_easy_q9);
// Question 10
        Question python_easy_q10 = new Question(
                "Python supports method overloading.",
                "True",
                "False",
                "Free",
                "Free",
                2,
                Question.DIFFICULTY_EASY,
                Category.PYTHON
        );
        insertQuestion(python_easy_q10);
// Question 11
        Question python_easy_q11 = new Question(
                "A Python function can return multiple values.",
                "True",
                "False",
                "Free",
                "Free",
                1,
                Question.DIFFICULTY_EASY,
                Category.PYTHON
        );
        insertQuestion(python_easy_q11);
// Question 12
        Question python_easy_q12 = new Question(
                "Python has a built-in switch statement.",
                "True",
                "False",
                "Free",
                "Free",
                2,
                Question.DIFFICULTY_EASY,
                Category.PYTHON
        );
        insertQuestion(python_easy_q12);
// Question 13
        Question python_easy_q13 = new Question(
                "The pop() method in Python removes the first element from a list.",
                "True",
                "False",
                "Free",
                "Free",
                2,
                Question.DIFFICULTY_EASY,
                Category.PYTHON
        );
        insertQuestion(python_easy_q13);
// Question 14
        Question python_easy_q14 = new Question(
                "Python allows you to directly access elements in a private class attribute.",
                "True",
                "False",
                "Free",
                "Free",
                2,
                Question.DIFFICULTY_EASY,
                Category.PYTHON
        );
        insertQuestion(python_easy_q14);
// Question 15
        Question python_easy_q15 = new Question(
                "Python has built-in support for multi-threading.",
                "True",
                "False",
                "Free",
                "Free",
                1,
                Question.DIFFICULTY_EASY,
                Category.PYTHON
        );
        insertQuestion(python_easy_q15);
// Question 16
        Question python_easy_q16 = new Question(
                "Python is case-sensitive.",
                "True",
                "False",
                "Free",
                "Free",
                1,
                Question.DIFFICULTY_EASY,
                Category.PYTHON
        );
        insertQuestion(python_easy_q16);
// Question 17
        Question python_easy_q17 = new Question(
                "The remove() method in Python removes the element at a specific index from a list.",
                "True",
                "False",
                "Free",
                "Free",
                2,
                Question.DIFFICULTY_EASY,
                Category.PYTHON
        );
        insertQuestion(python_easy_q17);
// Question 18
        Question python_easy_q18 = new Question(
                "Python allows multiple inheritance.",
                "True",
                "False",
                "Free",
                "Free",
                1,
                Question.DIFFICULTY_EASY,
                Category.PYTHON
        );
        insertQuestion(python_easy_q18);
// Question 19
        Question python_easy_q19 = new Question(
                "The break statement can be used to terminate a loop prematurely in Python.",
                "True",
                "False",
                "Free",
                "Free",
                1,
                Question.DIFFICULTY_EASY,
                Category.PYTHON
        );
        insertQuestion(python_easy_q19);
// Question 20
        Question python_easy_q20 = new Question(
                "Python uses indentation to define blocks of code.",
                "True",
                "False",
                "Free",
                "Free",
                1,
                Question.DIFFICULTY_EASY,
                Category.PYTHON
        );
        insertQuestion(python_easy_q20);

        //-----------------Python Medium---------------------------------
        // Question 1
        Question python_medium_q1 = new Question(
                "What is Python?",
                "high-level programming language",
                "low-level programming language",
                "A markup language",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );

// Question 2
        Question python_medium_q2 = new Question(
                "Which keyword is used to define a function in Python?",
                "def",
                "function",
                "define",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );

// Question 3
        Question python_medium_q3 = new Question(
                "Which of the following is a valid variable name in Python?",
                "123var",
                "var123",
                "my-var",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );

// Question 4
        Question python_medium_q4 = new Question(
                "Which data type is used to store a sequence of characters in Python?",
                "int",
                "char",
                "str",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );

// Question 5
        Question python_medium_q5 = new Question(
                "How do you write a single-line comment in Python?",
                "// This is a comment",
                "/* This is a comment */",
                "# This is a comment",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );

// Question 6
        Question python_medium_q6 = new Question(
                "Which loop is used to iterate over a sequence in Python?",
                "for",
                "while",
                "loop",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );

// Question 7
        Question python_medium_q7 = new Question(
                "Which function is used to get the length of a list in Python?",
                "size()",
                "length()",
                "len()",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );

// Question 8
        Question python_medium_q8 = new Question(
                "How do you remove an element from a set in Python?",
                "remove()",
                "delete()",
                "discard()",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );

// Question 9
        Question python_medium_q9 = new Question(
                "What is the result of the expression ‘bool(0)’ in Python?",
                "True",
                "False",
                "0",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );

// Question 10
        Question python_medium_q10 = new Question(
                "Which of the following is used to create a tuple in Python?",
                "[1, 2, 3]",
                "(1, 2, 3)",
                "{1, 2, 3}",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );

// Question 11
        Question python_medium_q11 = new Question(
                "Which method is used to convert a string to uppercase in Python?",
                "toUpperCase()",
                "upper()",
                "uppercase()",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );

// Question 12
        Question python_medium_q12 = new Question(
                "How do you check if a key is present in a dictionary in Python?",
                "check()",
                "contains()",
                "in",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );

// Question 13
        Question python_medium_q13 = new Question(
                "How do you define an empty dictionary in Python?",
                "{}",
                "{[]}",
                "dict()",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );

// Question 14
        Question python_medium_q14 = new Question(
                "Which of the following loops is used to iterate over a sequence of elements in Python?",
                "while loop",
                "for loop",
                "do-while loop",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );

// Question 15
        Question python_medium_q15 = new Question(
                "What is the purpose of the ‘break’ statement in Python?",
                "It terminates the program.",
                "It stops the current iteration of the loop and resumes with the next iteration.",
                "It exits from the current loop prematurely.",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );

// Question 16
        Question python_medium_q16 = new Question(
                "In Python, which of the following represents the \"not equal\" comparison operator?",
                "==",
                "!=",
                "<>",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );

// Question 17
        Question python_medium_q17 = new Question(
                "How do you chain multiple conditions together in an if statement?",
                "Using commas (,)",
                "Using the and keyword",
                "Using the or keyword",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );

// Question 18
        Question python_medium_q18 = new Question(
                "The if-else statement is also known as a/an:",
                "Ternary operator",
                "Loop statement",
                "Sequential statement",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );

// Question 19
        Question python_medium_q19 = new Question(
                "In Python, which of the following is used to handle multiple conditions in a more concise way?",
                "if-else statement",
                "Nested if statements",
                "Ternary operator",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );

// Question 20
        Question python_medium_q20 = new Question(
                "What is the purpose of the elif statement in Python?",
                "To create an alias for a variable",
                "To catch and handle exceptions",
                "To specify an alternative condition to check",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );

// Inserting all questions
        insertQuestion(python_medium_q1);
        insertQuestion(python_medium_q2);
        insertQuestion(python_medium_q3);
        insertQuestion(python_medium_q4);
        insertQuestion(python_medium_q5);
        insertQuestion(python_medium_q6);
        insertQuestion(python_medium_q7);
        insertQuestion(python_medium_q8);
        insertQuestion(python_medium_q9);
        insertQuestion(python_medium_q10);
        insertQuestion(python_medium_q11);
        insertQuestion(python_medium_q12);
        insertQuestion(python_medium_q13);
        insertQuestion(python_medium_q14);
        insertQuestion(python_medium_q15);
        insertQuestion(python_medium_q16);
        insertQuestion(python_medium_q17);
        insertQuestion(python_medium_q18);
        insertQuestion(python_medium_q19);
        insertQuestion(python_medium_q20);


        //--------------------------Python Hard------------------------------
        Question python_hard_q1 = new Question("To print \"Hello, World!\" to the console\n" +
                "\n" +
                "print(\"__________\")\n",
                "Hello, World!", "Hello World!", "“Hello World!”","“Hello, World!”", 1,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        insertQuestion(python_hard_q1);

        Question python_hard_q2 = new Question("To create a variable \"x\" and assign it the value 10\n" +
                "\n" +
                "_ = 10\n",
                "“x”", "x", "“X”","X", 2,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        insertQuestion(python_hard_q2);

        Question python_hard_q3 = new Question("What is the correct syntax to define a function in Python?\n" +
                "\n" +
                "def my_function():\n" +
                "    ________________\n",
                "return", "print()", "pass","def", 3,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        insertQuestion(python_hard_q3);

        Question python_hard_q4 = new Question("How do you read input from the user in Python?\n" +
                "\n" +
                "name = ________________\n",
                "input()", "read()", "get_input()","user_input()", 1,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        insertQuestion(python_hard_q4);

        Question python_hard_q5 = new Question("How do you check if a variable x is of integer type in Python?\n" +
                "\n" +
                "if ________________:\n" +
                "    print(\"x is an integer.\")\n",
                "type(x) == int", "x.isint()", "isinstance(x, int)","x.type == int", 1,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        insertQuestion(python_hard_q5);

        Question python_hard_q6 = new Question("To check if a number is even using an if statement:\n" +
                "\n" +
                "num = 10\n" +
                "if ______ % 2 == 0:\n" +
                "    print(\"Even\")\n" +
                "else:\n" +
                "    print(\"Odd\")\n",
                "Num", "num", "number","Number", 2,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        insertQuestion(python_hard_q6);

        Question python_hard_q7 = new Question("How do you convert the string \"25\" to an integer in Python?\n" +
                "\n" +
                "x = \"25\"\n" +
                "result = ________________\n",
                "int(x)", "str(x)", "float(x)","x.to_int()", 1,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        insertQuestion(python_hard_q7);

        Question python_hard_q8 = new Question("To import the \"math\" module:\n" +
                "\n" +
                "import ______\n",
                "import", "importmath", "math","ImportMath", 3,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        insertQuestion(python_hard_q8);

        Question python_hard_q9 = new Question("THow do you add a new element '6' to the end of the list my_list in Python?\n" +
                "\n" +
                "my_list = [1, 2, 3, 4, 5]\n" +
                "______________\n",
                "my_list.append(6)", "my_list.add(6)", "my_list.insert(6)","my_list.extend(6)", 1,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        insertQuestion(python_hard_q9);

        Question python_hard_q10 = new Question("What is the correct way to comment a single line in Python?\n" +
                "\n" +
                "# This is a ___________ comment.\n",
                "Single-line", "Inline", "Multi-line","Double-line", 1,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        insertQuestion(python_hard_q10);

        Question python_hard_q11 = new Question("To create a new list \"squared_numbers\" containing the squares of the numbers from the original list:\n" +
                "\n" +
                "numbers = [1, 2, 3, 4, 5]\n" +
                "squared_numbers = [______ for num in numbers]\n",
                "Num ++ 2", "num ** 2", "num ++ 2","Num ** 2", 2,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        insertQuestion(python_hard_q11);

        Question python_hard_q12 = new Question("To concatenate two strings \"str1\" and \"str2\" using the \"+\" operator:\n" +
                "\n" +
                "str1 = \"Hello, \"\n" +
                "str2 = \"World!\"\n" +
                "result = str1 + ______\n",
                "str2", "result", "str1","World!", 1,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        insertQuestion(python_hard_q12);

        Question python_hard_q13 = new Question("How do you check if a key 'my_key' exists in a dictionary 'my_dict' in Python?\n" +
                "\n" +
                "if ________________ in my_dict:\n" +
                "    print(\"Key exists.\")\n",
                "key 'my_key'", "my_key in dict", "my_key in my_dict","key_exists(my_dict, my_key)", 3,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        insertQuestion(python_hard_q13);

        Question python_hard_q14 = new Question("What does the len() function in Python return?\n" +
                "\n" +
                "my_string = \"Hello, World!\"\n" +
                "result = len(__________)\n" +
                "print(result)\n",
                "my_string", "my_string()", "my_string.length","my_string.length()", 1,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        insertQuestion(python_hard_q14);

        Question python_hard_q15 = new Question("To convert the string \"123\" to an integer:\n" +
                "\n" +
                "num_str = \"123\"\n" +
                "num = int(______)\n",
                "int", "123", "num","num_str", 4,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        insertQuestion(python_hard_q15);

        Question python_hard_q16 = new Question("How do you convert the floating-point number 3.14 to a string in Python?\n" +
                "\n" +
                "x = 3.14\n" +
                "result = ________________\n",
                "str(x)", "x.to_str()", "float(x)","x.str()", 1,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        insertQuestion(python_hard_q16);

        Question python_hard_q17 = new Question("How do you remove the last element from a list my_list in Python?\n" +
                "\n" +
                "my_list = [1, 2, 3, 4, 5]\n" +
                "______________\n",
                "my_list.remove(5)", "my_list.delete(-1)", "my_list.pop()","my_list.pop(0)", 3,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        insertQuestion(python_hard_q17);

        Question python_hard_q18 = new Question("To implement a function that takes a list of strings and returns a new list with the strings sorted by their length in ascending order:\n" +
                "\n" +
                "def sort_by_length(strings):\n" +
                "    return sorted(strings, key=______)\n",
                "boolean", "len", "length","return", 2,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        insertQuestion(python_hard_q18);

        Question python_hard_q19 = new Question("To implement a custom sorting function that sorts a list of strings based on the number of vowels in each string:\n" +
                "\n" +
                "def count_vowels(word):\n" +
                "    return sum(1 for char in word if char.lower() in \"aeiou\")\n" +
                "\n" +
                "def custom_sort(words):\n" +
                "    return sorted(words, key=______)\n",
                "custom sort", "char.lower", "count_vowels","double", 3,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        insertQuestion(python_hard_q19);

        Question python_hard_q20 = new Question("To  implement a function that finds the intersection of two arrays:\n" +
                "\n" +
                "def array_intersection(nums1, nums2):\n" +
                "    set_nums1 = set(nums1)\n" +
                "    set_nums2 = set(nums2)\n" +
                "    return [num for num in set_nums1 if num ______ set_nums2]\n",
                "for", "is", "in","at", 3,
                Question.DIFFICULTY_HARD, Category.PYTHON);
        insertQuestion(python_hard_q20);

    }

    public void addQuestion(Question question) {
        db = getWritableDatabase();
        insertQuestion(question);
    }

    public void addQuestions(List<Question> questions) {
        db = getWritableDatabase();

        for (Question question : questions) {
            insertQuestion(question);
        }
    }

    private void insertQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_DIFFICULTY, question.getDifficulty());
        cv.put(QuestionsTable.COLUMN_CATEGORY_ID, question.getCategoryID());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    @SuppressLint("Range")
    public List<Category> getAllCategories() {
        List<Category> categoryList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + CategoriesTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Category category = new Category();
                category.setId(c.getInt(c.getColumnIndex(CategoriesTable._ID)));
                category.setName(c.getString(c.getColumnIndex(CategoriesTable.COLUMN_NAME)));
                categoryList.add(category);
            } while (c.moveToNext());
        }

        c.close();
        return categoryList;
    }

    @SuppressLint("Range")
    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(c.getInt(c.getColumnIndex(QuestionsTable._ID)));
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                question.setCategoryID(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY_ID)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    @SuppressLint("Range")
    public ArrayList<Question> getQuestions(int categoryID, String difficulty) {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String selection = QuestionsTable.COLUMN_CATEGORY_ID + " = ? " +
                " AND " + QuestionsTable.COLUMN_DIFFICULTY + " = ? ";
        String[] selectionArgs = new String[]{String.valueOf(categoryID), difficulty};

        Cursor c = db.query(
                QuestionsTable.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(c.getInt(c.getColumnIndex(QuestionsTable._ID)));
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setDifficulty(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
                question.setCategoryID(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY_ID)));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }
}