package care_fragments.quiz;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import care_fragments.quiz.QuizContract.*;

import java.util.ArrayList;
import java.util.Collections;
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
        Category c3 = new Category("C#");
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
        Question java_easy_q1 = new Question(
                "Java is short for “JavaScript”.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q1);

        Question java_easy_q2 = new Question(
                "The coffee produced on the island of Java gained a reputation for its quality and became widely known as \"Java\" coffee, eventually leading to the association of the term with coffee in general.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q2);

        Question java_easy_q3 = new Question(
                "Java is an object -oriented, class-based high-level tool with a focus on minimizing the need for various implementation dependencies.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q3);

        Question java_easy_q4 = new Question(
                "Coffee is still produced on the Indonesian island of Java today, although its significance in the global coffee market has evolved over time.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q4);

        Question java_easy_q5 = new Question(
                "Java is an interpreted programming language, which means that the code is executed line by line as it's written",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q5);

        Question java_easy_q6 = new Question(
                "Java was released n May 1995 as a core component of Sun Microsystems’ Java platform.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q6);

        Question java_easy_q7 = new Question(
                "Java applications can only be run on Windows operating systems.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q7);

        Question java_easy_q8 = new Question(
                "Java is a purely functional programming language, meaning that it doesn't allow for mutable variables or state changes.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q8);

        Question java_easy_q9 = new Question(
                "the JVM acts as an interpreter, allowing the java code to be executed on different operating systems.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q9);
        Question java_easy_q10 = new Question(
                "java is fast, reliable and secure.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q10);
        Question java_easy_q11 = new Question(
                "a syntax is a collection of values and the operations that can be performed on those values?",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q11);
        Question java_easy_q12 = new Question(
                "single line comments (‘//’) are suitable for short explanations?",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q12);
        Question java_easy_q13 = new Question(
                "multi line comment (‘/*...*/’), on th other hand, are useful for  long explanations?",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q13);
        Question java_easy_q14 = new Question(
                "can comments slow down a programs execution?",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q14);
        Question java_easy_q15 = new Question(
                "in, java there are no several built- in data types that you can use to store different kinds of values?",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q15);
        Question java_easy_q16 = new Question(
                "the if statement is the simplest form of a conditional statement?",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q16);
        Question java_easy_q17 = new Question(
                "the if is in lowercase letters. Uppercase letters (If or IF) will generate an error?",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q17);
        Question java_easy_q18 = new Question(
                "the array is stored at the oth index, 2nd element is stored at 1st index, and so on?",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q18);
        Question java_easy_q19 = new Question(
                "a variable is a named storage location that holds a value of a particular type?",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q19);
        Question java_easy_q20 = new Question(
                "the arithmetic operator used for addition in java is the plus operator (+)?",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q20);
        Question java_easy_q21 = new Question(
                "In Java, the switch statement can only be used with integer data types and cannot be used with strings or characters. Is this statement true or false?",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q21);
        Question java_easy_q22 = new Question(
                "In Java, the if statement can only have a single condition.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q22);
        Question java_easy_q23 = new Question(
                "The switch statement in Java can be used with floating-point numbers (e.g., float or double).",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q23);
        Question java_easy_q24 = new Question(
                "A single if statement can have multiple corresponding else blocks.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q24);
        Question java_easy_q25 = new Question(
                "The == operator in Java compares the content of two objects.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q25);
        Question java_easy_q26 = new Question(
                "The syntax for an if statement in Java includes parentheses for enclosing the condition.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q26);
        Question java_easy_q27 = new Question(
                "A ternary operator in Java returns a boolean value.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q27);
        Question java_easy_q28 = new Question(
                "In Java, a conditional statement is used to execute a block of code only if a certain condition",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q28);
        Question java_easy_q29 = new Question(
                "The if statement in Java is used for creating loops.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q29);
        Question java_easy_q30 = new Question(
                "The condition in a do-while loop is checked before executing the loop body.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q30);
        Question java_easy_q31 = new Question(
                "can I make a program without using an identifier?",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q31);
        Question java_easy_q32 = new Question(
                "they are essential for code documentation, readability, and collaboration.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q32);
        Question java_easy_q33 = new Question(
                "can comments slow down a program’s execution?",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q33);
        Question java_easy_q34 = new Question(
                "it allow you to store and manipulate data within a program. Before using a variable, you need to declare it, specifying its type and name.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q34);
        Question java_easy_q35 = new Question(
                "the do- while loop is similar to the while loop, but it guarantees that the loop body is executed at least once.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q35);
        Question java_easy_q36 = new Question(
                "the foreach loop is commonly used when you know the number of iterations in advance",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q36);
        Question java_easy_q37 = new Question(
                "in oop an object represents an instance of a method, which acts as a blueprint or template for constructing objects.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q37);
        Question java_easy_q38 = new Question(
                "a class is like anobject constructor, or a blueprint for creating objects",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q38);
        Question java_easy_q39 = new Question(
                "encapsulation encourages the use of public methods, known as getters and setters, to interact with the attributes rather than directly accessing them.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q39);
        Question java_easy_q40 = new Question(
                "constructors are crucial in the construction and initialization of objects in both the superclass and the subclass in the context of inheritance.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q40);
        Question java_easy_q41 = new Question(
                "Java applications can only run on Windows operating systems.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q41);
        Question java_easy_q42 = new Question(
                "Java supports multiple inheritance through classes.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q42);
        Question java_easy_q43 = new Question(
                "Java is platform-independent due to its \"Write Once, Run Anywhere\" (WORA) principle.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q43);
        Question java_easy_q44 = new Question(
                "Java programs are compiled into machine code for a specific computer architecture.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q44);
        Question java_easy_q45 = new Question(
                "All variables in Java must be explicitly declared with a type before they can be used.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q45);
        Question java_easy_q46 = new Question(
                "Java code is compiled into machine code.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q46);
        Question java_easy_q47 = new Question(
                "Java is platform-dependent, meaning code written on one platform may not run on another.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q47);
        Question java_easy_q48 = new Question(
                "Java is not suitable for web development.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q48);
        Question java_easy_q49 = new Question(
                "Java is free and open-source software.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q49);
        Question java_easy_q50 = new Question(
                "All variables in Java must be explicitly declared with a data type.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q50);

        Question java_medium_q1 = new Question(
                "The language was initially developed by?",
                "James Gostling",
                "Guido van Rossum",
                "Anders Hejlsberg",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );
        insertQuestion(java_medium_q1);

        Question java_medium_q2 = new Question(
                "The original name of the Java programming language was?",
                "Coffee",
                "JavaScript",
                "Oak",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );
        insertQuestion(java_medium_q2);

        Question java_medium_q3 = new Question(
                "In which year was the Java programming language first released to the public?",
                "1990",
                "1993",
                "1995",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );
        insertQuestion(java_medium_q3);

        Question java_medium_q4 = new Question(
                "Who founded Sun Microsystems, the company responsible for creating the Java programming language?",
                "Bill Gates",
                "Steve Jobs",
                "Larry Ellison",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );
        insertQuestion(java_medium_q4);

        Question java_medium_q5 = new Question(
                "What prompted the creators of Java to settle on its name after brainstorming various alternatives?",
                "It was inspired by an island they visited during their vacation.",
                "It was a nod to the popular Indonesian coffee.",
                "It represented a fusion of ideas from different programming languages.",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q5);

        Question java_medium_q6 = new Question(
                "Where does the coffee known as 'Java' come from?",
                "The coffee known as 'Java' comes from the Indonesian island of Java.",
                "The coffee known as 'Java' comes from the Paris c’tea of Java",
                "The coffee known as 'Java' comes from the Jamaica Blue Mountain of Java",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q6);

        Question java_medium_q7 = new Question(
                "What is used to store whole numbers?",
                "double",
                "Boolean",
                "int",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q7);

        Question java_medium_q8 = new Question(
                "What is a correct syntax to output 'Hello World' in Java?",
                "Console.WriteLine(\"Hello World\");",
                "print(\"Hello World\");",
                "System.out.println(\"Hello World\");",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q8);

        Question java_medium_q9 = new Question(
                "How do you insert COMMENTS in Java code?",
                "// This is a comment",
                "/* This is a comment",
                "# This is a comment",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q9);

        Question java_medium_q10 = new Question(
                "What is used to store instances of user-defined classes?",
                "array",
                "object",
                "class",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q10);
        Question java_medium_q11 = new Question(
                "Stores text, such as HelloWorld. Double quotes are used to enclose string values?",
                "int",
                "String",
                "float",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q11);

        Question java_medium_q12 = new Question(
                "Stores integers or whole numbers, without decimals, such as 246 or -246?",
                "int",
                "String",
                "float",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q12);

        Question java_medium_q13 = new Question(
                "Stores floating-point numbers, with decimals, such as 3.99 or -3.99?",
                "int",
                "String",
                "float",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q13);

        Question java_medium_q14 = new Question(
                "Used to specify a new condition to test if the first condition is false.",
                "if",
                "else",
                "else if",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q14);

        Question java_medium_q15 = new Question(
                "Used to specify a block of code to be executed if the same condition is false.",
                "if",
                "else",
                "else if",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q15);

        Question java_medium_q16 = new Question(
                "Used to specify multiple conditions and control the flow of your program.",
                "nested if",
                "else",
                "else if",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q16);

        Question java_medium_q17 = new Question(
                "The loop commonly used when you know the number of iterations in advance.",
                "foreach",
                "do-while",
                "for",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q17);

        Question java_medium_q18 = new Question(
                "The loop specifically designed for iterating over elements of an array or a collection.",
                "foreach",
                "do-while",
                "for",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q18);

        Question java_medium_q19 = new Question(
                "Also known as a one-dimensional array, these are the simplest form of arrays that anyone can easily understand.",
                "passing array",
                "single dimensional array",
                "multidimensional array",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q19);

        Question java_medium_q20 = new Question(
                "Arrays inside of arrays, where elements can be an array itself.",
                "passing array",
                "single dimensional array",
                "multidimensional array",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q20);

        Question java_medium_q21 = new Question(
                "What was the original name of Java?",
                "oak",
                "javascript",
                "coffee",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q21);

        Question java_medium_q22 = new Question(
                "The programming language we know today as Java was named after a type of?",
                "oak",
                "javascript",
                "coffee =",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q22);

        Question java_medium_q23 = new Question(
                "Java has a built-in exception handling mechanism that allows you to catch and handle errors and exceptional situations in your code.",
                "standard library",
                "garbage collection",
                "exception handling",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q23);

        Question java_medium_q24 = new Question(
                "Java provides a rich set of libraries and APIs (Application Programming Interfaces) that simplify common programming tasks.",
                "standard library",
                "garbage collection",
                "exception handling",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q24);

        Question java_medium_q25 = new Question(
                "Java has automatic memory management through a process called?",
                "standard library",
                "garbage collection",
                "exception handling",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q25);

        Question java_medium_q26 = new Question(
                "Java has a syntax similar to other programming languages like C and C++.",
                "lists",
                "array",
                "syntax",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q26);

        Question java_medium_q27 = new Question(
                "Java is an object-oriented programming (OOP) language. This means that it revolves around the concept of objects, which are instances of classes.",
                "Object-Oriented Programming",
                "object-oriented programming",
                "object oriented program",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q27);

        Question java_medium_q28 = new Question(
                "Java is a write once, run anywhere language. This means that once you write a Java program, you can run it on any platform.",
                "standard library",
                "garbage collection",
                "platform independence",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q28);

        Question java_medium_q29 = new Question(
                "In Java, the source code is compiled into bytecode, which is then executed by?",
                "java virtual machine",
                "java virt machine",
                "java virtual mach",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q29);

        Question java_medium_q30 = new Question(
                "This compilation step helps to optimize performance and allows the code to be run on any platform with a compatible",
                "jvm",
                "jcm",
                "jhm",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q30);

        Question java_medium_q31 = new Question(
                "Originally, Sun Microsystems developed this language and it was available for use in May?",
                "1993",
                "1995",
                "1996",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q31);

        Question java_medium_q32 = new Question(
                "A class is a blueprint for creating objects.",
                "main method",
                "class method",
                "system.out.println",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q32);

        Question java_medium_q33 = new Question(
                "Each program processing starts from the main() method which is a mandatory part of every Java program.",
                "main method",
                "class method",
                "system.out.println",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q33);

        Question java_medium_q34 = new Question(
                "It is used to print and display an output to the user.",
                "main method",
                "class method",
                "system.out.println",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q34);

        Question java_medium_q35 = new Question(
                "It is a built-in Java class that contains useful members, such as out, which is short for “output”.",
                "main method",
                "class method",
                "system",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q35);

        Question java_medium_q36 = new Question(
                "It is usually written in a specific format that can be used to document program elements such as classes, interfaces, methods, fields, etc.",
                "single line comments",
                "multi line comments",
                "Javadoc comments",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q36);

        Question java_medium_q37 = new Question(
                "Refers to the process of accepting data or information from a user during the execution of a Java program.",
                "java user input",
                "java actor input",
                "java admin input",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q37);

        Question java_medium_q38 = new Question(
                "Primitive data types include the following:",
                "byte, short, int, float, double, Boolean, and char.",
                "byte, short, int, long,  float, double, Boolean, and char.",
                "strings, arrays, object, interface, and classes",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q38);

        Question java_medium_q39 = new Question(
                "Non-primitive data types include the following:",
                "byte, short, int, float, double, Boolean, and char.",
                "byte, short, int, long,  float, double, Boolean, and char.",
                "strings, arrays, object, interface, and classes",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q39);

        Question java_medium_q40 = new Question(
                "Used to assign values to variables.",
                "arithmetic operators",
                "operators for assignment",
                "logical operators",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q40);

        Question java_medium_q41 = new Question(
                "Class attributes are often declared as private in encapsulation, which means they may only be accessed within the class itself.",
                "java class attributes",
                "java class methods",
                "java constructors",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q41);

        Question java_medium_q42 = new Question(
                "Class methods are critical for encapsulation, which is one of the key ideas of object-oriented programming (OOP).",
                "java class attributes",
                "java class methods",
                "java constructors",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q42);

        Question java_medium_q43 = new Question(
                "Constructors serve an important part in encapsulation by providing a means for initializing an object's state.",
                "java class attributes",
                "java class methods",
                "java constructors",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q43);

        Question java_medium_q44 = new Question(
                "Modifiers play an important role in encapsulation because they govern the access levels of class members (variables and methods) and determine their visibility and accessibility from other sections of the program.",
                "java class attributes",
                "java class methods",
                "java modifiers",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q44);

        Question java_medium_q45 = new Question(
                "Polymorphism, one of the main ideas of object-oriented programming, is implemented through classes and objects.",
                "java classes and objects",
                "java class methods",
                "java modifiers",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q45);

        Question java_medium_q46 = new Question(
                "Through method overriding, class methods play a part in polymorphism.",
                "java classes and objects",
                "java class methods",
                "java modifiers",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q46);

        Question java_medium_q47 = new Question(
                "Constructors are essential for creating objects and initializing their state.",
                "java class attributes",
                "java class methods",
                "java constructors",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q47);

        Question java_medium_q48 = new Question(
                "When dealing with polymorphism, access modifiers also play a role in setting the visibility and accessibility of methods and variables.",
                "java classes and objects",
                "java class methods",
                "java modifiers",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q48);

        Question java_medium_q49 = new Question(
                "It is a variable declared within a class that represents an object's status or data.",
                "java class attributes",
                "java class methods",
                "java constructors",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q49);

        Question java_medium_q50 = new Question(
                "Access modifiers play a role in setting the visibility of abstract classes, abstract methods, and interface methods when it comes to abstraction.",
                "java classes and objects",
                "java class methods",
                "java modifiers",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.JAVA
        );insertQuestion(java_medium_q50);

        //------------------------------------Java Question Hard------------------------------




        Question java_hard_q1 = new Question(
                "What is the missing part of the code below to output \"Hello World\".\n\npublic class MyClass {\n  public static void main(String[] args) {\n    ____(\"Hello World\");\n  }\n}",
                "Console.WriteLine",
                "print",
                "System.out.println",
                "String.out",
                3,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q1);

        Question java_hard_q2 = new Question(
                "Comments in Java are written with special characters. What is the missing part?\n\n__ This is a single-line comment",
                "//",
                "/*",
                "*/",
                "\\",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q2);

        Question java_hard_q3 = new Question(
                "Comments in Java are written with special characters. What is the missing part?\n\n__ This is a multi-line comment __",
                "// and //",
                "/* and */",
                "*/ and /*",
                "\\ and \\",
                2,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q3);

        Question java_hard_q4 = new Question(
                "What is the correct data type for the variable?\n\n__ myNum = 9;",
                "float",
                "int",
                "char",
                "boolean",
                2,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q4);

        Question java_hard_q5 = new Question(
                "What is the correct data type for the variable?\n\n__ myFloatNum = 8.99f;",
                "String",
                "Boolean",
                "char",
                "float",
                4,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q5);

        Question java_hard_q6 = new Question(
                "What is the correct data type for the variable?\n\n__ myLetter = 'A';",
                "char",
                "int",
                "String",
                "Boolean",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q6);

        Question java_hard_q7 = new Question(
                "What is the correct data type for the variable?\n\n__ myBool = false;",
                "String",
                "float",
                "char",
                "Boolean",
                4,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q7);

        Question java_hard_q8 = new Question(
                "What is the correct data type for the variable?\n\n__ myText = \"Hello World\";",
                "int",
                "float",
                "String",
                "Boolean",
                3,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q8);

        Question java_hard_q9 = new Question(
                "byte, short, int, long, float, double, boolean, and char are called?",
                "primitive",
                "reference",
                "non primitive",
                "non reference",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q9);

        Question java_hard_q10 = new Question(
                "Type casting - Convert the following double type (myDouble) to an int type:\n\ndouble myDouble = 9.78d;\nint myInt = (__) myDouble;",
                "float",
                "double",
                "int",
                "short",
                3,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q10);

        Question java_hard_q11 = new Question(
                "Multiply 10 with 5, and print the result.\n\nSystem.out.println(10__5);",
                "*",
                "x",
                "/",
                "none",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q11);

        Question java_hard_q12 = new Question(
                "Divide 10 by 5, and print the result.\n\nSystem.out.println(10__5);",
                "%",
                "\\",
                "/",
                "&",
                3,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q12);

        Question java_hard_q13 = new Question(
                "Use the addition assignment operator to add the value 5 to the variable x.\n\nint x = 10;\nx__5;",
                "- =",
                "*=",
                "+=",
                "/=",
                3,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q13);

        Question java_hard_q14 = new Question(
                "Print the second item in the cars array.\n\nString[] cars = {\"Volvo\", \"BMW\", \"Ford\"};\nSystem.out.println(__);",
                "cars[1]",
                "cars[2]",
                "cars[3]",
                "cars[0]",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q14);

        Question java_hard_q15 = new Question(
                "Find out how many elements the cars array has.\n\nString[] cars = {\"Volvo\", \"BMW\", \"Ford\"};\nSystem.out.println(__);",
                "cars.length",
                "cars.Length",
                "Cars.length",
                "cars.length.",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q15);

        Question java_hard_q16 = new Question(
                "What is the missing part to create a two-dimensional array?\n\n__ myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };",
                "char[][]",
                "String[][]",
                "double[][]",
                "int[][]",
                4,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q16);

        Question java_hard_q17 = new Question(
                "Create a class called MyClass.\n\npublic class __",
                "class",
                "myObj",
                "myMethod",
                "MyClass",
                4,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q17);

        Question java_hard_q18 = new Question(
                "The class below should not be inherited by other classes. Add the correct modifier:\n\n__class MyClass",
                "final",
                "Final",
                "FINAL",
                "none",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q18);

        Question java_hard_q19 = new Question(
                "Fill in the missing parts to import the java.util.Scanner class from the Java API:\n\nImport java.util.__;",
                "Scan",
                "Scanner",
                "scanner",
                "scan",
                2,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q19);

        Question java_hard_q20 = new Question(
                "The Car class should inherit the attributes and methods from the Vehicle class. Add the correct keyword to make this possible.\n\nclass Car ___ Vehicle",
                "extend",
                "extends",
                "Extends",
                "Extend",
                2,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q20);

        Question java_hard_q21 = new Question(
                "In Java, every statement must end with a __________.",
                "semicolon (;)",
                "comma (,)",
                "colon (:)",
                "period (.)",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q21);

        Question java_hard_q22 = new Question(
                "The entry point of a Java program is the _________ method.",
                "main",
                "start",
                "execute",
                "run",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q22);

        Question java_hard_q23 = new Question(
                "A class can be defined using the keyword __________.",
                "category",
                "style",
                "class",
                "type",
                3,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q23);

        Question java_hard_q24 = new Question(
                "The keyword used to create an object of a class is _________.",
                "make",
                "object",
                "new",
                "create",
                3,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q24);

        Question java_hard_q25 = new Question(
                "The data type used to store single characters in Java is _________.",
                "char",
                "character",
                "string",
                "letter",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q25);

        Question java_hard_q26 = new Question(
                "The default value of a boolean variable is _________.",
                "false",
                "true",
                "0",
                "1",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q26);

        Question java_hard_q27 = new Question(
                "The operator used for exponentiation in Java is _________.",
                "^",
                "**",
                "^^",
                "ex",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q27);

        Question java_hard_q28 = new Question(
                "The loop that executes a block of code at least once is _________ loop.",
                "for",
                "while",
                "do-while",
                "until",
                3,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q28);

        Question java_hard_q29 = new Question(
                "The symbol used to access members of an object is _________.",
                ".",
                "->",
                "::",
                "::",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q29);

        Question java_hard_q30 = new Question(
                "The ternary operator in Java is represented as _________.",
                "?",
                "||",
                ":",
                "::",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q30);

        Question java_hard_q31 = new Question(
                "Java arrays have _________ indexing.",
                "zero-based",
                "one-based",
                "negative",
                "random",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q31);

        Question java_hard_q32 = new Question(
                "The keyword used to declare a method that can be called without creating an instance of the class is _________.",
                "public",
                "static",
                "shared",
                "common",
                2,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q32);

        Question java_hard_q33 = new Question(
                "The Java keyword used to exit from a loop prematurely is _________.",
                "break",
                "stop",
                "exit",
                "quit",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q33);

        Question java_hard_q34 = new Question(
                "The keyword used to declare a variable that can hold different data types is _________.",
                "mixed",
                "dynamic",
                "variant",
                "Object",
                4,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q34);

        Question java_hard_q35 = new Question(
                "The Java keyword used to refer to the superclass is _________.",
                "base",
                "parent",
                "super",
                "upper",
                3,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q35);

        Question java_hard_q36 = new Question(
                "The method used to convert a number to a string is _________.",
                "toString",
                "convertToString",
                "numberToString",
                "stringify",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q36);

        Question java_hard_q37 = new Question(
                "The Java keyword used to implement multiple interfaces is _________.",
                "use",
                "implement",
                "extends",
                "extends and implements",
                2,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q37);

        Question java_hard_q38 = new Question(
                "The keyword used to create an instance of an abstract class is _________.",
                "new",
                "create",
                "instantiate",
                "construct",
                3,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q38);

        Question java_hard_q39 = new Question(
                "The operator used for a bitwise left shift in Java is _________.",
                "<<",
                ">>",
                "<<",
                ">>",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q39);

        Question java_hard_q40 = new Question(
                "Java is an ______________ programming language.",
                "Object-oriented",
                "Procedural",
                "Functional",
                "Scripting",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q40);

        Question java_hard_q41 = new Question(
                "Every Java program must have a ______________ method as the entry point.",
                "main",
                "start",
                "execute",
                "run",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q41);

        Question java_hard_q42 = new Question(
                "In Java, comments are ignored by the ______________.",
                "Compiler",
                "Interpreter",
                "Debugger",
                "Runtime environment",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q42);

        Question java_hard_q43 = new Question(
                "The Java keyword used to declare a variable is ______________.",
                "variable",
                "var",
                "int",
                "declare",
                2,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q43);

        Question java_hard_q44 = new Question(
                "In Java, the line terminator is represented by _______.",
                "\\t",
                "\\n",
                "\\r",
                "\\l",
                2,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q44);

        Question java_hard_q45 = new Question(
                "In Java, a variable must be declared before _______.",
                "a. Using it",
                "b. using",
                "c. used",
                "d. this",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q45);

        Question java_hard_q46 = new Question(
                "The entry point of a Java program is the ________ method.",
                "start()",
                "main()",
                "entry()",
                "execute()",
                2,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q46);

        Question java_hard_q47 = new Question(
                "The \"if\" statement is used for ________.",
                "declaring variables",
                "looping",
                "decision-making",
                "printing output",
                3,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q47);

        Question java_hard_q48 = new Question(
                "The \"continue\" statement is used to ________.",
                "end a loop",
                "restart the loop",
                "skip the current iteration and continue to the next",
                "pause the loop temporarily",
                3,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q48);

        Question java_hard_q49 = new Question(
                "In Java, a variable must be declared before it can be ________.",
                "assigned a value",
                "printed",
                "used in a loop",
                "defined as a method",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q49);

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

        Collections.shuffle(questionList);

        // Limit the list to 10 questions
        if (questionList.size() > 25) {
            questionList.subList(25, questionList.size()).clear();
        }
        return questionList;
    }
}