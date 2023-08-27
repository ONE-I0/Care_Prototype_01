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
                "What is the missing part of the code below to output \"Hello World\".\n\npublic class MyClass {\n  public static void main(String[] args) {\n    ________________(\"Hello World\");\n  }\n}",
                "Console.WriteLine",
                "print",
                "System.out.println",
                "String.out",
                3,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q1);

        Question java_hard_q2 = new Question(
                "Comments in Java are written with special characters. What is the missing part?\n\n________ This is a single-line comment",
                "//",
                "/*",
                "*/",
                "\\",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q2);

        Question java_hard_q3 = new Question(
                "Comments in Java are written with special characters. What is the missing part?\n\n________ This is a multi-line comment ________",
                "// and //",
                "/* and */",
                "*/ and /*",
                "\\ and \\",
                2,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q3);

        Question java_hard_q4 = new Question(
                "What is the correct data type for the variable?\n\n________ myNum = 9;",
                "float",
                "int",
                "char",
                "boolean",
                2,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q4);

        Question java_hard_q5 = new Question(
                "What is the correct data type for the variable?\n\n________ myFloatNum = 8.99f;",
                "String",
                "Boolean",
                "char",
                "float",
                4,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q5);

        Question java_hard_q6 = new Question(
                "What is the correct data type for the variable?\n\n________ myLetter = 'A';",
                "char",
                "int",
                "String",
                "Boolean",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q6);

        Question java_hard_q7 = new Question(
                "What is the correct data type for the variable?\n\n________ myBool = false;",
                "String",
                "float",
                "char",
                "Boolean",
                4,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q7);

        Question java_hard_q8 = new Question(
                "What is the correct data type for the variable?\n\n________ myText = \"Hello World\";",
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
                "Type casting - Convert the following double type (myDouble) to an int type:\n\ndouble myDouble = 9.78d;\nint myInt = (________) myDouble;",
                "float",
                "double",
                "int",
                "short",
                3,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q10);

        Question java_hard_q11 = new Question(
                "Multiply 10 with 5, and print the result.\n\nSystem.out.println(10________5);",
                "*",
                "x",
                "/",
                "none",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q11);

        Question java_hard_q12 = new Question(
                "Divide 10 by 5, and print the result.\n\nSystem.out.println(10________5);",
                "%",
                "\\",
                "/",
                "&",
                3,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q12);

        Question java_hard_q13 = new Question(
                "Use the addition assignment operator to add the value 5 to the variable x.\n\nint x = 10;\nx________5;",
                "- =",
                "*=",
                "+=",
                "/=",
                3,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q13);

        Question java_hard_q14 = new Question(
                "Print the second item in the cars array.\n\nString[] cars = {\"Volvo\", \"BMW\", \"Ford\"};\nSystem.out.println(________);",
                "cars[1]",
                "cars[2]",
                "cars[3]",
                "cars[0]",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q14);

        Question java_hard_q15 = new Question(
                "Find out how many elements the cars array has.\n\nString[] cars = {\"Volvo\", \"BMW\", \"Ford\"};\nSystem.out.println(________);",
                "cars.length",
                "cars.Length",
                "Cars.length",
                "cars.length.",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q15);

        Question java_hard_q16 = new Question(
                "What is the missing part to create a two-dimensional array?\n\n________ myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };",
                "char[][]",
                "String[][]",
                "double[][]",
                "int[][]",
                4,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q16);

        Question java_hard_q17 = new Question(
                "Create a class called MyClass.\n\npublic class ________",
                "class",
                "myObj",
                "myMethod",
                "MyClass",
                4,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q17);

        Question java_hard_q18 = new Question(
                "The class below should not be inherited by other classes. Add the correct modifier:\n\n________class MyClass",
                "final",
                "Final",
                "FINAL",
                "none",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q18);

        Question java_hard_q19 = new Question(
                "Fill in the missing parts to import the java.util.Scanner class from the Java API:\n\nImport java.util.________;",
                "Scan",
                "Scanner",
                "scanner",
                "scan",
                2,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q19);

        Question java_hard_q20 = new Question(
                "The Car class should inherit the attributes and methods from the Vehicle class. Add the correct keyword to make this possible.\n\nclass Car _________ Vehicle",
                "extend",
                "extends",
                "Extends",
                "Extend",
                2,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(java_hard_q20);

        Question java_hard_q21 = new Question(
                "In Java, every statement must end with a ________.",
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
                "Using it",
                "using",
                "used",
                "this",
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

        //---------------------------Python EASY---------------------------
        Question python_easy_q1 = new Question(
                "It was initially designed by Guido van Rossum in 1991 and developed by Python Software Foundation",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q1);

        Question python_easy_q2 = new Question(
                "The name of the Python programming language comes from an old BBC television comedy sketch series called Monty Python's Flying Circus.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q2);

        Question python_easy_q3 = new Question(
                "The \"print\" function in Python is used to send messages directly to outer space through radio waves.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q3);

        Question python_easy_q4 = new Question(
                "Python is a popular high-level programming language with clean syntax that is easy to learn.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q4);

        Question python_easy_q5 = new Question(
                "Python is known for its simplicity and readability, and ability to run on all desktop computers and even mobile devices.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q5);

        Question python_easy_q6 = new Question(
                "It is dubbed as the “hardest programming language in the world”.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q6);

        Question python_easy_q7 = new Question(
                "Python is not compatible with a number of operating systems, including Rasberry Pi, Mac, and Linux.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q7);

        Question python_easy_q8 = new Question(
                "Python has a straightforward syntax that resembles that of English language.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q8);

        Question python_easy_q9 = new Question(
                "Python is not be used in procedural, object-oriented, or functional programming environments.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q9);
        Question python_easy_q10 = new Question(
                "Python is exclusively a web-based language and can only be run in a web browser.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q10);

        Question python_easy_q11 = new Question(
                "Python doesn't support loops or iteration; all programs must be written using only conditional statements.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q11);

        Question python_easy_q12 = new Question(
                "Python is an ancient programming language that was first developed in the 18th century by a group of mathematicians and philosophers.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q12);

        Question python_easy_q13 = new Question(
                "Python runs on an interpreter system, allowing code to be executed immediately after it has been written. ",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q13);

        Question python_easy_q14 = new Question(
                "The python identifier defines a set of rules that are used to create python statements while writing a python program.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q14);

        Question python_easy_q15 = new Question(
                "A python syntax is a name used to identify a variable, function, class, module, or other object.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q15);

        Question python_easy_q16 = new Question(
                "Comments enhance the readability of the code and help the programmers to understand the code very carefully.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q16);

        Question python_easy_q17 = new Question(
                "Variables are containers for storing data values.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q17);
        Question python_easy_q18 = new Question(
                "Variable names with more than one word can be difficult to read",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q18);

        Question python_easy_q19 = new Question(
                "The numerous classes or kinds of values that variable can contain are referred to as “inputs’",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q19);
        Question python_easy_q20 = new Question(
                "The logical operator used to perform a logical AND operation in Python is the “and” keyword.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q20);

        Question python_easy_q21 = new Question(
                "Python is a dynamically typed programming language.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q21);

        Question python_easy_q22 = new Question(
                "In Python, the \"==\" operator is used for assignment.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q22);

        Question python_easy_q23 = new Question(
                "Python lists are immutable, meaning their elements cannot be changed after creation.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q23);

        Question python_easy_q24 = new Question(
                "Indentation is not important in Python and does not affect the code's functionality.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q24);

        Question python_easy_q25 = new Question(
                "A tuple in Python is an ordered and mutable collection of elements.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q25);

        Question python_easy_q26 = new Question(
                "In Python, you can use single-line comments using the \"#\" symbol.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q26);

        Question python_easy_q27 = new Question(
                "Python supports both procedural and object-oriented programming paradigms.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q27);

        Question python_easy_q28 = new Question(
                "Python is a compiled programming language.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q28);

        Question python_easy_q29 = new Question(
                "Python uses braces {} to indicate code blocks.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q29);

        Question python_easy_q30 = new Question(
                "Python is an object-oriented programming (OOP) language.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q30);
        Question python_easy_q31 = new Question(
                "A variable name in Python can start with a number.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q31);
        Question python_easy_q32 = new Question(
                "The 'print' function in Python can only output strings.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q32);
        Question python_easy_q33 = new Question(
                "Python supports multiple inheritance, where a class can inherit from multiple parent classes.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q33);
        Question python_easy_q34 = new Question(
                "Python places a strong emphasis on the readability of its code",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q34);
        Question python_easy_q35 = new Question(
                "Python is dynamically typed, which implies that variable types are decided upon automatically while the program is running.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q35);
        Question python_easy_q36 = new Question(
                "Python has a robust ecosystem of third-party modules and frameworks that increase its functionality.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q36);
        Question python_easy_q37 = new Question(
                "Workflows can be made with python and other technologies",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q37);
        Question python_easy_q38 = new Question(
                "Arrays can be developed on a server using python",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q38);
        Question python_easy_q39 = new Question(
                "Database systems are connectable with python. Files can also be read and changed by it.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q39);
        Question python_easy_q40 = new Question(
                "Big data management and advanced mathematical operations can both be done with python",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q40);
        Question python_easy_q41 = new Question(
                "Python can be used to produce software that is ready for productions or for rapid prototyping",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q41);
        Question python_easy_q42 = new Question(
                "A Python function must always return a value.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q42);
        Question python_easy_q43 = new Question(
                "Comments in Python start with the symbols //",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q43);
        Question python_easy_q44 = new Question(
                "Python is compatible with a number of operating systems, including Raspberry Pi,Mac, and Linux",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q44);
        Question python_easy_q45 = new Question(
                "Python is a straightforward syntax that resembles that of English language.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q45);
        Question python_easy_q46 = new Question(
                "Python cannot be used in procedural, object-oriented, or functional programming environments",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q46);
        Question python_easy_q47 = new Question(
                "Python input() function is used to get input from the user.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q47);
        Question python_easy_q48 = new Question(
                "you may manipulate and calculate on data, compare values, assign values, and do many other things with operators.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q48);
        Question python_easy_q49 = new Question(
                "when assigning values to variables, assignment operators are utilized.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q49);
        Question python_easy_q50 = new Question(
                "A Boolean result of true or false is returned when a relational operator compares two values.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.PYTHON);
        insertQuestion(python_easy_q50);

        Question python_medium_q1 = new Question(
                "Python places a strong emphasis on the readability of its code. Instead of utilizing braces or keywords to separate pieces of code, it employs indentation.",
                "Dynamic typing",
                "Simple and clear syntax ",
                "Strong standard library",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );
        insertQuestion(python_medium_q1);

        Question python_medium_q2 = new Question(
                "Python has a sizable standard library that includes modules for a variety of needs, including file I/O, networking, regular expressions, and more.",
                "Dynamic typing",
                "Simple and clear syntax t",
                "Strong standard library ",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );
        insertQuestion(python_medium_q2);

        Question python_medium_q3 = new Question(
                "Python is dynamically typed, which implies that variable types are decided upon automatically while the program is running. ",
                "Dynamic typing ",
                "Simple and clear syntax ",
                "Strong standard library ",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );
        insertQuestion(python_medium_q3);

        Question python_medium_q4 = new Question(
                "What is a correct syntax to output \"Hello World\" in Python?",
                "Echo “Hello World”",
                "Print(“Hello World”)",
                "P(“Hello World”)",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );
        insertQuestion(python_medium_q4);

        Question python_medium_q5 = new Question(
                "Python accepts single (‘), double (“) and triple (“’ or “’) quotes to denote string literals, as long as the same type of quote starts and ends the string. ",
                "Python lines and indentation",
                "Python multi-line statements",
                "Quotation in python",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q5);

        Question python_medium_q6 = new Question(
                "Statements in python typically end with a new line.",
                "Python lines and indentation",
                "Python multi-line statements ",
                "Python symbol",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q6);

        Question python_medium_q7 = new Question(
                "Each word starts with a capital letter",
                "Carnel case",
                "Pascal case",
                "Snake case",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q7);

        Question python_medium_q8 = new Question(
                "Each word is separated by an underscore character",
                "Carnel case",
                "Pascal case",
                "Snake case",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q8);

        Question python_medium_q9 = new Question(
                "Each word, except the first, starts with a capital letter.",
                "Carnel case",
                "Pascal case",
                "Snake case",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q9);

        Question python_medium_q10 = new Question(
                "Used to store key-value pairs",
                "Boolean data type",
                "List data type",
                "Dictionary data type ",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q10);
        Question python_medium_q11 = new Question(
                "Used to store an   unordered collection of unique items.",
                "String data type ",
                "Set data type",
                "Tuple data type",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q11);

        Question python_medium_q12 = new Question(
                "Used to store sequences of characters (text).",
                "Set data type",
                "List data type",
                "String data type",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q12);

        Question python_medium_q13 = new Question(
                "When comparing the identities of two objects, identity operators are utilized.",
                "Bitwise operators",
                "Assignment operators.",
                "None of the above",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q13);

        Question python_medium_q14 = new Question(
                "It returns true if both the operands on its left and right evaluate to true, otherwise, it returns false.",
                "Logical OR",
                "Logical AND",
                "Logical NOT",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q14);

        Question python_medium_q15 = new Question(
                "It is a compact way to write a simple if-else statement in a single line",
                "If-else statement",
                "If-elif-else statement",
                "Ternary operator",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q15);

        Question python_medium_q16 = new Question(
                "It returns the opposite Boolean value of the operand.",
                "Logical NOT",
                "Logical OR",
                "Logical AND",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q16);

        Question python_medium_q17 = new Question(
                "Used to exit a current loop prematurely, regardless of the loop condition",
                "While loop",
                "Continue statement",
                "break statement ",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q17);

        Question python_medium_q18 = new Question(
                "Used to skip the current iteration of a loop and move to the next iteration",
                "While loop",
                "Continue statement ",
                "break statement ",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q18);

        Question python_medium_q19 = new Question(
                "Python is data structure that contains a group of elements of the same type",
                "Lists",
                "Tuple",
                "Array ",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q19);

        Question python_medium_q20 = new Question(
                "Removes the element at the specified position",
                "Remove()",
                "Pop()",
                "Index()",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q20);

        Question python_medium_q21 = new Question(
                "Python is a programming paradigm based on the concept of objects.",
                "OOP",
                "OOF",
                "POO",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q21);

        Question python_medium_q22 = new Question(
                "Classes and objects play an important role in encapsulation, which is one of the core ideas of object-oriented programming (OOP). Encapsulation is the practice of grouping data and methods into a class and controlling access to them from outside the class",
                "Encapsulation",
                "Encaps",
                "Capsul",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q22);

        Question python_medium_q23 = new Question(
                "Play an important part in encapsulation, which is one of the core principles of object-oriented programming (OOP).encapsulation is the process of grouping data and methods within a class and restricting access to them from outside the class.",
                "Attri",
                "Attributes",
                "Atribute",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q23);

        Question python_medium_q24 = new Question(
                "In encapsulation, allow you to create functions that run on the class itself rather than individual instances of the class.",
                "Classic method",
                "Clas method",
                "Class methods",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q24);

        Question python_medium_q25 = new Question(
                "In encapsulation, one of the core concepts of object-oriented programming (OOP), is one of the functions played by?",
                "Constructors",
                "contrast",
                "control",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q25);

        Question python_medium_q26 = new Question(
                "In inheritance refer to the variables or properties that are inherited by a subclass from its superclass.",
                "attributes",
                "atributes",
                "attribute",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q26);

        Question python_medium_q27 = new Question(
                "One of the core ideas of object-oriented programming(OOP), it is implemented in large part via classes and objects. A class can take on traits and behaviors from another class, known as the superclass or base class",
                "Inherit",
                "inheritance",
                "enheritance",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q27);

        Question python_medium_q28 = new Question(
                "In inheritance, it is strong ideas that enable the development of reusable code and hierarchical interactions between classes.",
                "Classic method",
                "Clas method",
                "Class methods",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q28);

        Question python_medium_q29 = new Question(
                "In inheritance, let child classes to add their own special properties while both inheriting and initializing data from their parent class.",
                "Constructors",
                "contrast",
                "control",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q29);

        Question python_medium_q30 = new Question(
                "One of the core concepts of object-oriented programming (OOP), depends heavily on classes and objects. When something is polymorphic, it can change its appearance or behave in a different way depending on the situation",
                "Poly",
                "polymorphism",
                "pholymorphisms",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q30);

        Question python_medium_q31 = new Question(
                "In polymorphism,  there are no explicit access modifiers like in some others programming languages(e.g., public,private,protected).",
                "modif",
                "modifier",
                "modifiers",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q31);

        Question python_medium_q32 = new Question(
                "In polymorphism, it is involves representing essential features of an object while hiding unnecessary details.it allows you to create abstract classes or interfaces that define a common set of methods without providing their implementation.",
                "Abst",
                "Attractions",
                "Abstraction",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q32);

        Question python_medium_q33 = new Question(
                "In polymorphism, are not directly involved in polymorphism, which is the property that allows objects to assume different forms and behave differently in response to method or function calls.",
                "Constructors",
                "Contrast",
                "Control",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q33);

        Question python_medium_q34 = new Question(
                "In polymorphism, are variables defined within a class and can hold data associated with instances of that class or the class itself.",
                "Attributes",
                "Atributes",
                "Attribute",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q34);

        Question python_medium_q35 = new Question(
                "In polymorphism, unlike several other programming languages, there are no explicit access modifiers like public, private, or protected.",
                "modif",
                "modifier",
                "modifiers",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q35);

        Question python_medium_q36 = new Question(
                "Classes and objects play a role in implementing abstraction, which is one of the fundamental principles of object-oriented programming(OOP). Abstraction involves representing essential features of an object while hiding unnecessary details. It allows you to create abstract classes or interfaces that define a common set of methods without providing their implementation.",
                "Abst",
                "Attractions",
                "Abstraction",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q36);

        Question python_medium_q37 = new Question(
                "Used to iterate over a sequence( such as a list, tuple, string, or range) or any iterable object.",
                "For loop",
                "while loop",
                "else statement in loops",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q37);

        Question python_medium_q38 = new Question(
                "Used to repeatedly execute a block of code as long as a condition is true.",
                "For loop",
                "while loop",
                "else statement in loops",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q38);

        Question python_medium_q39 = new Question(
                "Used to exit the current loop prematurely, regardless of the loop condition ",
                "Stop statement",
                "Continue statement",
                "Break statement",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q39);

        Question python_medium_q40 = new Question(
                "Used to skip the current iteration of a loop and move to the next iteration.",
                "Pause statement",
                "Continue statement",
                "Break statement",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q40);

        Question python_medium_q41 = new Question(
                "It is used to execute a block of code if a condition is true",
                "If statement",
                "If-else statement",
                "If-elif-else statement",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q41);

        Question python_medium_q42 = new Question(
                "It allows you too execute one block of code if a condition is true and another block of code if the condition is false.",
                "If statement",
                "If-else statement",
                "If-elif-else statement",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q42);

        Question python_medium_q43 = new Question(
                "It allows you to test multiple conditions and execute different blocks of code based on the first condition that evaluates to true. ",
                "If statement",
                "If-else statement",
                "If-elif-else statement",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q43);

        Question python_medium_q44 = new Question(
                "it is a compact way to write a simple if-else statement in a single line.",
                "Nested if statement",
                "Ternary operator",
                "Switch statement",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q44);

        Question python_medium_q45 = new Question(
                "You can nest if statements within other if statements to create more complex conditions.",
                "Nested if statement",
                "Ternary operator",
                "Switch operator",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q45);

        Question python_medium_q46 = new Question(
                "It returns true if both the operands on its left and right evaluate to true, otherwise, it returns false.",
                "Logical AND ",
                "Logical &",
                "Logical N",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q46);

        Question python_medium_q47 = new Question(
                "It returns true if at least one of the operands on its left or right evaluates to true. If both operands are false, it returns false",
                "Logical /",
                "Logical OR",
                "Logical o",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q47);

        Question python_medium_q48 = new Question(
                "It returns the opposite Boolean value of the operand. If the operand is true, it returns false, and if the operand is false, it returns true.",
                "Logical NOT",
                "Logical no",
                "Logical none",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q48);

        Question python_medium_q49 = new Question(
                "It is a potent python package for numerical computation, it presents the highly optimized array (dimensional array) data structure, which is used to store and manipulate huge, homogeneous data arrays.",
                "Numpy library ",
                "Numpy operator",
                "Numpy module",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q49);

        Question python_medium_q50 = new Question(
                "What is the arithmetic operator used for exponentiation in python",
                "**",
                "//",
                "&&",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_medium_q50);

        //------------------------------------Java Question Hard------------------------------

        Question python_hard_q1 = new Question(
                "How do you print \"Hello World\" in python?",
                "Print(\"Hello World\") ",
                "P(\"Hello World\")",
                "Print(\"Hello World\");",
                "P(\"Hello World\");",
                1,
                Question.DIFFICULTY_HARD,
                Category.JAVA
        );insertQuestion(python_hard_q1);

        Question python_hard_q2 = new Question(
                "Comments in Python are written with a special character, which one?\n__ This is a comment",
                "A. /*",
                "B. //",
                "C. #",
                "D. /",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_hard_q2);

        Question python_hard_q3 = new Question(
                "The following code example would print the data type of x, what data type would that be?\nX = 5\nPrint(type(x))",
                "A. Int",
                "B. Float",
                "C. Str",
                "D. Bool",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_hard_q3);

        Question python_hard_q4 = new Question(
                "The following code example would print the data type of x, what data type would that be?\nX = \"Hello World\"\nPrint(type(x))",
                "A. Int",
                "B. Float",
                "C. Str",
                "D. Bool",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_hard_q4);

        Question python_hard_q5 = new Question(
                "The following code example would print the data type of x, what data type would that be?\nX = 20.5\nPrint(type(x))",
                "A. Int",
                "B. Float",
                "C. Str",
                "D. Bool",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_hard_q5);

        Question python_hard_q6 = new Question(
                "The following code example would print the data type of x, what data type would that be?\nX = [\"apple\", \"banana\", \"cherry\"]\nPrint(type(x))",
                "A. List",
                "B. Float",
                "C. Str",
                "D. Bool",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_hard_q6);

        Question python_hard_q7 = new Question(
                "The following code example would print the data type of x, what data type would that be?\nX = (\"apple\", \"banana\", \"cherry\")\nPrint(type(x))",
                "A. List",
                "B. Float",
                "C. Int",
                "D. tuple",
                4,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_hard_q7);

        Question python_hard_q8 = new Question(
                "The following code example would print the data type of x, what data type would that be?\nX = {\"name\" : \"John\", \"age\" : 36}\nPrint(type(x))",
                "A. Float",
                "B. Int",
                "C. Dict",
                "D. Float",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_hard_q8);

        Question python_hard_q9 = new Question(
                "The following code example would print the data type of x, what data type would that be?\nX = True\nPrint(type(x))",
                "A. List",
                "B. Int",
                "C. Bool",
                "D. Boolean",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_hard_q9);

        Question python_hard_q10 = new Question(
                "The statement below would print a Boolean value, which one?\nPrint(10 > 9)",
                "A. True",
                "B. False",
                "C. 10",
                "D. 9",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.PYTHON
        );insertQuestion(python_hard_q10);

        Question python_hard_q11 = new Question(
                "The statement below would print a Boolean value, which one?\nPrint(10 == 9)\n__",
                "True",
                "False",
                "Equal to equal",
                "Equal",
                2,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q12 = new Question(
                "Multiply 10 with 5, and print the result.\nPrint(10__5)\n__",
                "%",
                "X",
                "/",
                "*",
                4,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q13 = new Question(
                "Divide 10 by 2, and print the result.\nPrint(10 __ 2)\n__",
                "%",
                "/",
                "( )",
                "$",
                2,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q14 = new Question(
                "Print \"Hello\" if a is equal to b, and c is equal to d.\nIf a == b __ c == d:\n  Print(\"Hello\")\n__",
                "Or",
                "And",
                "Not",
                "&",
                2,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q15 = new Question(
                "Print \"Hello\" if a is equal to b, or if c is equal to d.\nIf a == b __ c == d:\n  Print(\"Hello\")\n__",
                "Or",
                "==",
                "And",
                "Not",
                1,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q16 = new Question(
                "Stop the loop if i is 3.\n" +
                        "i = 1\n" +
                        "while i < 6:\n" +
                        "  if i == 3:\n" +
                        "    __",
                "Continue",
                "If",
                "For",
                "Break =",
                4,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q17 = new Question(
                "In the loop, when i is 3, jump directly to the next iteration.\n" +
                        "i = 0\n" +
                        "while i < 6:\n" +
                        "  i += 1\n" +
                        "  if i == 3:\n" +
                        "    __",
                "Continue =",
                "If",
                "For",
                "Break",
                4,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );



// Python for loops
        Question python_hard_q18 = new Question(
                "In the loop, when the item value is \"banana\", jump directly to the next item.\n" +
                        "fruits = [\"apple\", \"banana\", \"cherry\"]\n" +
                        "for x in fruits:\n" +
                        "  if x == \"banana\":\n" +
                        "   __",
                "Continue =",
                "If",
                "For",
                "Break",
                1,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q19 = new Question(
                "Use the range function to loop through a code set 6 times.\n" +
                        "for x in __:\n" +
                        "   print(x)",
                "range(6):",
                "range(6) =",
                "range (6)",
                "range(6);",
                2,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q20 = new Question(
                "Exit the loop when x is \"banana\".\n" +
                        "fruits = [\"apple\", \"banana\", \"cherry\"]\n" +
                        "for x in fruits:\n" +
                        "  if x == \"banana\":\n" +
                        "    __",
                "Continue",
                "If",
                "For",
                "Break =",
                4,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q21 = new Question(
                "One should be looking to the index number where the specific element is located.\n",
                "Access the elements of an array",
                "The length of an array",
                "Looping array elements",
                "Adding array elements",
                1,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q22 = new Question(
                "Use the len() method to return the length of an array or simply, the number of elements in an array.\n",
                "Access the elements of an array",
                "The length of an array =",
                "Looping array elements",
                "Adding array elements",
                2,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q23 = new Question(
                "For in loop can be used to access array elements.\n",
                "Access the elements of an array",
                "The length of an array",
                "Looping array elements",
                "Adding array elements =",
                4,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q24 = new Question(
                "To add more elements in an array, just use the append() method.\n",
                "Access the elements of an array",
                "The length of an array",
                "Looping array elements",
                "Adding array elements",
                3,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q25 = new Question(
                "There are two ways to remove an element from the array. It can be pop() or remove() method.",
                "Access the elements of an array",
                "The length of an array",
                "Looping array elements",
                "Removing array elements",
                4,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );
        Question python_hard_q26 = new Question(
                "adds an element at the end of the list",
                "Append()",
                "clear()",
                "Copy()",
                "count()",
                1,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );
        Question python_hard_q27 = new Question(
                "returns a copy of the list",
                "Append()",
                "clear()",
                "Copy()",
                "count()",
                3,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );
        Question python_hard_q28 = new Question(
                "Removes all the elements from the list",
                "Append()",
                "clear()",
                "Copy()",
                "count()",
                2,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );Question python_hard_q29 = new Question(
                "returns the number of elements with the specified value",
                "Append()",
                "clear()",
                "Copy()",
                "count()",
                4,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );
        Question python_hard_q30 = new Question(
                "add the elements of a list (or any iterable), to the end of the current list.",
                "index()",
                "Extend()",
                "insert()",
                "pop()",
                2,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );
        Question python_hard_q31 = new Question(
                "returns the index of the first element with the specified value",
                "index()",
                "Extend()",
                "insert()",
                "pop()",
                1,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q32 = new Question(
                "removes the element at the specified position",
                "index()",
                "Extend()",
                "insert()",
                "pop()",
                4,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );Question python_hard_q33 = new Question(
                "adds an element at the specified position",
                "index()",
                "Extend()",
                "insert()",
                "pop()",
                3,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );
        Question python_hard_q34 = new Question(
                "removes the first item with the specified value",
                "Reverse()",
                "sort()",
                "remove()",
                "Pop()",
                3,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );
        Question python_hard_q35 = new Question(
                "reverse the order of the list",
                "Reverse()",
                "sort()",
                "remove()",
                "Pop()",
                1,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q36 = new Question(
                "Sorts the list.",
                "A. Reverse()",
                "B. sort() =",
                "C. remove()",
                "D. Pop()",
                2,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q37 = new Question(
                "Use the correct syntax to print the first item in the fruits tuple.\n" +
                        "Fruits = (\"apple\", \"banana\", \"cherry\")\n" +
                        "Print(________)",
                "A. Fruits[0] =",
                "B. Fruits[1]",
                "C. Apple",
                "D. Banana",
                1,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q38 = new Question(
                "Use the correct syntax to print the number of items in the fruits tuple.\n" +
                        "Fruits = (\"apple\", \"banana\", \"cherry\")\n" +
                        "Print(________)\n",
                "A. Len(fruit)",
                "B. Len(fruits)",
                "C. Len(Fruits) =",
                "D. Lengths(fruits)",
                3,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q39 = new Question(
                "Use negative indexing to print the last item in the tuple.\n" +
                        "Fruits = (\"apple\", \"banana\", \"cherry\")\n" +
                        "Print(________)",
                "A. Fruits[2]",
                "B. Fruits[-2]",
                "C. Fruits[1]",
                "D. Fruits[-1] =",
                4,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q40 = new Question(
                "Use a range of indexes to print the third, fourth, and fifth item in the tuple.\n" +
                        "Fruits = (\"apple\", \"banana\", \"cherry\", \"orange\", \"kiwi\", \"melon\", \"mango\")\n" +
                        "Print(________)",
                        "A. Fruits[2 , 5]",
                        "B. Fruits[2 and 5]",
                        "C. Fruits[2 &5]",
                        "D. Fruits[2:5] =",
                4,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );
        Question python_hard_q41 = new Question(
                "Use the add method to add \"orange\" to the fruits set.\n" +
                        "Fruits = {\"apple\", \"banana\", \"cherry\"}\n",
                "A. Fruits.remove(\"orange\")",
                "B. Fruits.insert(\"orange\")",
                "C. Fruits.add(\"orange\")",
                "D. Fruits.pop(\"orange\")",
                3,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question  python_hard_q42 = new Question(
                "Use the correct method to add multiple items (more_fruits) to the fruits set.\n" +
                        "Fruits = {\"apple\", \"banana\", \"cherry\"}\n" +
                        "More_fruits = [\"orange\", \"mango\", \"grapes\"]\n",
                "A. Fruits.reverse(more_fruits)",
                "B. Fruits.index(more_fruits)",
                "C. Fruits.add(more_fruits)",
                "D. Fruits.update(more_fruits)",
                4,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q43 = new Question(
                "Use the remove method to remove \"banana\" from the fruits set.\n" +
                        "Fruits = {\"apple\", \"banana\", \"cherry\"}\n",
                "A. fruits.insert(\"banana\")",
                "B. Fruits.pop(\"banana\")",
                "C. Fruits.sort(\"banana\")",
                "D. Fruits.remove(\"banana\")",
                4,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q44 = new Question(
                "Print the second item in the fruits list.\n" +
                        "Fruits = [\"apple\", \"banana\", \"cherry\"]\n",
                "A. Fruits[1]",
                "B. Fruits[2]",
                "C. Fruits[-2]",
                "D. Fruits[-1]",
                1,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q45 = new Question(
                "Use the append method to add \"orange\" to the fruits list.\n" +
                        "Fruits = [\"apple\", \"banana\", \"cherry\"]\n",
                "A. Fruits.sort(\"orange\")",
                "B. Fruits.remove(\"orange\")",
                "C. Fruits.append(\"orange\")",
                "D. Fruits.clear(\"orange\")",
                3,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q46 = new Question(
                "Use the remove method to remove \"banana\" from the fruits list.\n" +
                        "Fruits = [\"apple\", \"banana\", \"cherry\"]\n",
                "A. fruits.sort(\"banana\")",
                "B. Fruits.remove(\"banana\") =",
                "C. Fruits.clear(\"banana\")",
                "D. Fruits.pop(\"banana\")",
                2,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q47 = new Question(
                "Use negative indexing to print the last item in the list.\n" +
                        "Fruits = [\"apple\", \"banana\", \"cherry\"]\n",
                "A. Fruits[-0]",
                "B. Fruits[-1] =",
                "C. Fruits[-2]",
                "D. Fruits[1]",
                2,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q48 = new Question(
                "Use a range of indexes to print the third, fourth, and fifth item in the list.\n" +
                        "Fruits = [\"apple\", \"banana\", \"cherry\", \"orange\", \"kiwi\", \"melon\", \"mango\"]\n" +
                        "Print(__________)",
                "A. Fruits[2:5] =",
                "B. Fruits[2 & 5]",
                "C. Fruits[2 and 5]",
                "D. Fruits[2 / 5]",
                1,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q49 = new Question(
                "Use the correct syntax to print the number of items in the list.\n" +
                        "Fruits = [\"apple\", \"banana\", \"cherry\"]\n" +
                        "Print(len(fruits)",
                "A. Lengths(fruits)",
                "B. Len(fruits) =",
                "C. LEN(fruits)",
                "D. Len(fruits) =",
                2,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        Question python_hard_q50 = new Question(
                "Use the insert method to add \"lemon\" as the second item in the fruits list\n" +
                        "Fruits = [\"apple\", \"banana\", \"cherry\"]\n"+
                        "__________ \"lemon\")",
                "A. Fruits.insert(1,",
                "B. Fruits.pop(1,",
                "C. Fruits.remove(1,",
                "D. Fruits.insert(1,",
                1,
                Question.DIFFICULTY_HARD,
                Category.PYTHON
        );

        insertQuestion(python_hard_q11);
        insertQuestion(python_hard_q12);
        insertQuestion(python_hard_q13);
        insertQuestion(python_hard_q14);
        insertQuestion(python_hard_q15);
        insertQuestion(python_hard_q16);
        insertQuestion(python_hard_q17);
        insertQuestion(python_hard_q18);
        insertQuestion(python_hard_q19);
        insertQuestion(python_hard_q20);
        insertQuestion(python_hard_q21);
        insertQuestion(python_hard_q22);
        insertQuestion(python_hard_q23);
        insertQuestion(python_hard_q24);
        insertQuestion(python_hard_q25);
        insertQuestion(python_hard_q26);
        insertQuestion(python_hard_q27);
        insertQuestion(python_hard_q28);
        insertQuestion(python_hard_q29);
        insertQuestion(python_hard_q30);
        insertQuestion(python_hard_q31);
        insertQuestion(python_hard_q32);
        insertQuestion(python_hard_q33);
        insertQuestion(python_hard_q34);
        insertQuestion(python_hard_q35);
        insertQuestion(python_hard_q36);
        insertQuestion(python_hard_q37);
        insertQuestion(python_hard_q38);
        insertQuestion(python_hard_q39);
        insertQuestion(python_hard_q40);
        insertQuestion(python_hard_q41);
        insertQuestion(python_hard_q42);
        insertQuestion(python_hard_q43);
        insertQuestion(python_hard_q44);
        insertQuestion(python_hard_q45);
        insertQuestion(python_hard_q46);
        insertQuestion(python_hard_q47);
        insertQuestion(python_hard_q48);
        insertQuestion(python_hard_q49);
        insertQuestion(python_hard_q50);



        //---------------------------C# EASY---------------------------
        Question c_easy_q1 = new Question(
                "The language was developed in the year 2000",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q1);

        Question c_easy_q2 = new Question(
                "Microsoft created the object-oriented programming language c#, which is pronounced c sharp.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q2);

        Question c_easy_q3 = new Question(
                "C# is a low-level programming language",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q3);

        Question c_easy_q4 = new Question(
                "C# stands for \"Carrot Sharp\" and was originally developed as a language for vegetable enthusiasts to communicate with their garden plants.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q4);

        Question c_easy_q5 = new Question(
                "C# is frequently used to create a variety of applications, including desktop, web, mobile, and game development applications.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q5);

        Question c_easy_q6 = new Question(
                "The most efficient way to write comments in C# is by using emojis instead of text, making your code more expressive and artistic.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q6);

        Question c_easy_q7 = new Question(
                "The \"foreach\" loop in C# is used to traverse parallel dimensions, allowing you to process data from alternate realities.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q7);

        Question c_easy_q8 = new Question(
                "The .NET runtime can then execute c# code that has been compiled into the intermediate language known as Common Intermediate Language (CIL)",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q8);

        Question c_easy_q9 = new Question(
                "C# is among the most widely used programming languages worldwide.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q9);
        Question c_easy_q10 = new Question(
                "A modern, object-oriented, and type-safe programming language.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q10);

        Question c_easy_q11 = new Question(
                "The c# comments are statements that are not executed by the compiler.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q11);

        Question c_easy_q12 = new Question(
                "the multi-line comment starts with // (double slash)",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q12);

        Question c_easy_q13 = new Question(
                "it is always a good practice to put comments for readability and consistency.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q13);

        Question c_easy_q14 = new Question(
                "in c#, all the variables must be declared before they can be used.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q14);

        Question c_easy_q15 = new Question(
                "To create a loop in C#, you need to use the \"goto\" statement to jump between different parts of your code.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q15);

        Question c_easy_q16 = new Question(
                "to create a variable that should store text you should use “string”",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q16);

        Question c_easy_q17 = new Question(
                "C# doesn't support object-oriented programming; all code must be written in a linear, procedural style.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q17);
        Question c_easy_q18 = new Question(
                "to create a variable that should store a number you should use “int”",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q18);

        Question c_easy_q19 = new Question(
                "to read inputs as integers in c#, use the convert",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q19);
        Question c_easy_q20 = new Question(
                "a data type defines the size and type of variable values.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q20);

        Question c_easy_q21 = new Question(
                "In C#, arrays can only contain strings.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q21);

        Question c_easy_q22 = new Question(
                "C# utilizes automatic memory management through garbage collection.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q22);

        Question c_easy_q23 = new Question(
                "Supports generics, allowing the creation of reusable code by writing classes and methods that work with different types.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q23);

        Question c_easy_q24 = new Question(
                "c# supports reflection, which allows developers to inspect and manipulate types, classes, methods, and other entities at runtime.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q24);

        Question c_easy_q25 = new Question(
                "The \"void\" keyword in C# indicates that a method will return a value.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q25);

        Question c_easy_q26 = new Question(
                "c# is so similar to c, c++, and java, programmers can easily switch from one to the other",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q26);

        Question c_easy_q27 = new Question(
                "constructors play a vital role in encapsulation, which is one of the fundamental principles of object-oriented programming (OOP).",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q27);

        Question c_easy_q28 = new Question(
                "Access modifiers are used to control the visibility and accessibility of classes, members (fields, properties, methods, etc.), and other elements within a program.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q28);

        Question c_easy_q29 = new Question(
                "In C#, \"++\" is used to decrease the value of a variable.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q29);

        Question c_easy_q30 = new Question(
                "Inheritance is one of the core ideas of object-oriented programming (OOP), and it is strongly related to classes and objects.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q30);
        Question c_easy_q31 = new Question(
                "Attributes and polymorphism are two distinct concepts that serve different purposes in object-oriented programming",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q31);
        Question c_easy_q32 = new Question(
                "as one of the fundamental ideas of object-oriented programming(OOP), inheritance, constructors play a significant role.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q32);
        Question c_easy_q33 = new Question(
                "C# was originally designed for interstellar communication.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q33);
        Question c_easy_q34 = new Question(
                "C# is a synonym for \"secret code.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q34);
        Question c_easy_q35 = new Question(
                "C# is strongly typed, which means you must declare the data type of a variable.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q35);
        Question c_easy_q36 = new Question(
                "C# is only used for web development and cannot create desktop applications.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q36);
        Question c_easy_q37 = new Question(
                "C# applications can be compiled into intermediate language code known as MSIL.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q37);
        Question c_easy_q38 = new Question(
                "C# supports multiple inheritance, allowing a class to inherit from multiple parent classes.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q38);
        Question c_easy_q39 = new Question(
                "C# is not influenced by the syntax of C and C++.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q39);
        Question c_easy_q40 = new Question(
                "C# supports delegates, which are type-safe function pointers that enable event-driven programming.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q40);
        Question c_easy_q41 = new Question(
                "C# has built-in support for asynchronous programming using the async and await keywords.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q41);
        Question c_easy_q42 = new Question(
                "C# was initially developed for translating ancient manuscripts.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q42);
        Question c_easy_q43 = new Question(
                "The purpose of a constructor in C# is to build sandcastles.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q43);
        Question c_easy_q44 = new Question(
                "C# has a syntax for defining and using attributes, which can be used for metadata.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q44);
        Question c_easy_q45 = new Question(
                "the powerful characteristic of attributes may  be applied to many other  elements of programming, including abstraction.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q45);
        Question c_easy_q46 = new Question(
                "abstraction involves representing essential features of an object while hiding unnecessary details.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q46);
        Question c_easy_q47 = new Question(
                "in order to offer more details or metadata about types, members, or other program elements, attributes might be employed.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q47);
        Question c_easy_q48 = new Question(
                "The \"static\" keyword in C# is used to prevent objects from moving.",
                "True", "False", "Free", "Free", 2,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q48);
        Question c_easy_q49 = new Question(
                "in order to initialize objects of a class, constructors are special procedures.",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q49);
        Question c_easy_q50 = new Question(
                "C# is a programming language",
                "True", "False", "Free", "Free", 1,
                Question.DIFFICULTY_EASY, Category.Csharp);
        insertQuestion(c_easy_q50);

        Question c_medium_q1 = new Question(
                "stores values with two states: true or false",
                "int",
                "double",
                "bool",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );
        insertQuestion(c_medium_q1);

        Question c_medium_q2 = new Question(
                "stores text, such as Hello World. String values are surrounded by double quotes",
                "string",
                "bool",
                "char",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );
        insertQuestion(c_medium_q2);

        Question c_medium_q3 = new Question(
                "stores single character, such as ‘a’ or ‘B’. char values are surrounded by single quotes.",
                "string",
                "int",
                "char",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );
        insertQuestion(c_medium_q3);

        Question c_medium_q4 = new Question(
                "stores integers (whole numbers), without decimals, such as 123 or -123.",
                "int",
                "double",
                "float”)",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );
        insertQuestion(c_medium_q4);

        Question c_medium_q5 = new Question(
                "stores floating point numbers, with decimals, such as 19.99 or -19.99",
                "float",
                "int",
                "double",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q5);

        Question c_medium_q6 = new Question(
                "used to store a collection of elements of the same type",
                "double",
                "array",
                "string",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q6);

        Question c_medium_q7 = new Question(
                "used to store instances of classes or as a base type for all other types in c#",
                "object",
                "array",
                "string",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q7);

        Question c_medium_q8 = new Question(
                "used to define a blueprint for creating objects",
                "object",
                "class",
                "char",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q8);

        Question c_medium_q9 = new Question(
                "used to define a set of named values",
                "Enum",
                "Struct",
                "Class",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q9);

        Question c_medium_q10 = new Question(
                "used to represent value types that can be assigned null",
                "Nullable Types",
                "Enum",
                "Struct ",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q10);
        Question c_medium_q11 = new Question(
                "a Boolean result of true or false is returned when a relational operator compares two values",
                "Boolean operators",
                "relational operators",
                "arithmetic operators",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q11);

        Question c_medium_q12 = new Question(
                "execute operations such addition (+), subtraction (-), multiplication (*), division (/), and modulus (%) in elementary mathematics .",
                "relational operators",
                "arithmetic operators",
                "Boolean operators",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q12);

        Question c_medium_q13 = new Question(
                "When comparing the identities of two objects, identity operators are utilized.",
                "identity operator",
                "bitwise operator",
                "assignment operator",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q13);

        Question c_medium_q14 = new Question(
                "is an expression that evaluates to either true or false",
                "conditions",
                "syntax",
                "lists",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q14);

        Question c_medium_q15 = new Question(
                "it returns the opposite Boolean value of the operand.",
                "logical AND",
                "logical NOT",
                "logical OR",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q15);

        Question c_medium_q16 = new Question(
                "it returns true if at least one of the operands on its left or right evaluates to true.",
                "Logical NOT",
                "Logical OR",
                "Logical AND",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q16);

        Question c_medium_q17 = new Question(
                "used to iterate over a sequence of values for a specified number of times.",
                "for loop ",
                "while loop",
                "do-while loop",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q17);

        Question c_medium_q18 = new Question(
                "used to store multiple values of the same data type in a contiguous block of memory",
                "for loop",
                "while loop",
                "array",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q18);

        Question c_medium_q19 = new Question(
                "to specify a blockof code to be executed, if a specified condition is truee",
                "else statement",
                "else if statement",
                "if statement",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q19);

        Question c_medium_q20 = new Question(
                "provides a concise way to express conditional statements.",
                "switch statement",
                "if statement",
                "ternary operator",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q20);

        Question c_medium_q21 = new Question(
                "used to iterate over a sequence of values for a specified number of times.",
                "for loop",
                "while loop",
                "do-while loop",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q21);

        Question c_medium_q22 = new Question(
                "used to repeatedly execute a block of code as long as a given condition is checked before each iteration.",
                "for loop",
                "while loop",
                "do-while loop",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q22);

        Question c_medium_q23 = new Question(
                "it is similar to a while loop, but the condition is checked after each iteration.",
                "for loop ",
                "while loop",
                "do-while loop",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q23);

        Question c_medium_q24 = new Question(
                "classes and objects are fundamental components of encapsulation, which is one of the core\n" +
                        "principles of object-oriented programming (OOP).\n",
                "inheritance",
                "encapsulation",
                "polymorphism",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q24);

        Question c_medium_q25 = new Question(
                "play an important role in implementing abstraction, which is one of the key principles of object-oriented programming (OOP). ",
                "classes and objects",
                "encapsulation",
                "polymorphism",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q25);

        Question c_medium_q26 = new Question(
                "in encapsulation, to various program elements including classes, methods, properties, and fields, attributes are used to add metadata or extra information.",
                "attributes",
                "atributes",
                "attribute",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q26);

        Question c_medium_q27 = new Question(
                "in encapsulation, access modifiers are used to control the visibility and accessibility of classes, members (fields, properties, methods, etc.), and other elements within a program.",
                "Inherit",
                "inheritance",
                "modifiers",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q27);

        Question c_medium_q28 = new Question(
                "play a vital role in encapsulation, which is one of the fundamental principles of object-oriented programming (OOP).",
                "contructors",
                "attributes",
                "Class methods",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q28);

        Question c_medium_q29 = new Question(
                "in inheritance, access modifiers play a crucial role in controlling the visibility and accessibility of members (variables, properties, methods, etc.)",
                "Constructors",
                "modifiers",
                "control",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q29);

        Question c_medium_q30 = new Question(
                "when it comes to inheritance, constructors assist in establishing the relationship between the base class (superclass) and derived classes (subclasses), allowing for the initialization of objects.",
                "contructors",
                "polymorphism",
                "pholymorphisms",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q30);

        Question c_medium_q31 = new Question(
                "in inheritance,  in order to offer more details or metadata about types, members, or other program elements, attributes might be employed.",
                "attri",
                "attributes",
                "atributes",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q31);

        Question c_medium_q32 = new Question(
                "in inheritance, the ability to inherit from another class enables for code reuse and the development of specialized classes based on pre-existing  ones.",
                "class",
                "classes and objects",
                "objects",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q32);

        Question c_medium_q33 = new Question(
                "one of the cornerstones of object-oriented programming (OOP) is polymorphism, and constructors can be utilized in the context of polymorphism.",
                "Constructors",
                "Contrast",
                "Control",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q33);

        Question c_medium_q34 = new Question(
                "the powerful characteristic of attributes may be applied to many other elements of programming, including abstraction.",
                "Attributes",
                "Atributes",
                "Attribute",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q34);

        Question c_medium_q35 = new Question(
                "you need to specify the data type of its elements and the size (number of elements) of the array.",
                "creating string",
                "creating lists",
                "creating array",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q35);

        Question c_medium_q36 = new Question(
                "using their index, which starts at 0 and goes up to Length – 1, where Length is the total number of elements in the array.",
                "accessing array elements",
                "modifying array elements",
                "insert array elements",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q36);

        Question c_medium_q37 = new Question(
                "by assigning new values to the elements using their indexes.",
                "accessing array elements",
                "modifying array elements",
                "insert array elements",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q37);

        Question c_medium_q38 = new Question(
                "you can use loops like for or foreach to iterate over the elements of an array.",
                "multidimensional arrays",
                "array methods and properties",
                "iterating over arrays",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q38);

        Question c_medium_q39 = new Question(
                "allowing you to create arrays with multiple dimensions (e.g., 2D arrays, 3D arrays).",
                "multidimensional arrays",
                "Continue statement",
                "Break statement",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q39);

        Question c_medium_q40 = new Question(
                "arrays provide useful methods and properties to work with arrays efficiently. Some of the commonly used ones are Length (property to get the number of elements), CopyTo() (method to copy elements to another array), Sort() (method to sort the array), etc.",
                "multidimensional arrays",
                "array methods and properties",
                "iterating over arrays",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q40);

        Question c_medium_q41 = new Question(
                "to specify a block of code to be executed, if a specified condition is true",
                "if",
                "else",
                "else if",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q41);

        Question c_medium_q42 = new Question(
                "used to represent value types that can be assigned null",
                "class",
                "enum",
                "Nullable types",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q42);

        Question c_medium_q43 = new Question(
                "used to define a lightweight structure that can contain data members",
                "class",
                "enum",
                "struct",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q43);

        Question c_medium_q44 = new Question(
                "choose  one of the many code blocks to run",
                "ternary operator",
                "switch statement",
                "else if",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q44);

        Question c_medium_q45 = new Question(
                "used to define a blueprint for creating objects",
                "class",
                "enum",
                "struct",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q45);

        Question c_medium_q46 = new Question(
                "operator returns true if both the left and right operands are true.",
                "AND",
                "and",
                "&",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q46);

        Question c_medium_q47 = new Question(
                "operator is unary operator that reverses the logical state of its operand.",
                "x",
                "nope",
                "NOT",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q47);

        Question c_medium_q48 = new Question(
                "operator returns true if at least one of the left or right operands is true.",
                "OR",
                "/",
                "=",
                "Free",
                1,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q48);

        Question c_medium_q49 = new Question(
                "c# supports various data types, which of the following are not",
                "reference types",
                "pointer types",
                "operator types",
                "Free",
                3,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q49);

        Question c_medium_q50 = new Question(
                "used to define set of named values",
                "class",
                "enum",
                "struct",
                "Free",
                2,
                Question.DIFFICULTY_MEDIUM,
                Category.Csharp
        );insertQuestion(c_medium_q50);

        Question csharp_q1 = new Question(
                "Insert the missing part of the code below to output \"Hello World!\".\n" +
                        "static void Main(string[] args){\n" +
                        "  Console.WriteLine(\"Hello World!\");\n" +
                        "}",
                "Console.WriteLine =",
                "print",
                "system.out.println",
                "printf",
                1,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q2 = new Question(
                "Comments in C# are written with special characters. Insert the missing parts:\n" +
                        "__ This is a single-line comment",
                "/*",
                "/",
                "///",
                "// =",
                4,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question  csharp_q3 = new Question(
                "Comments in C# are written with special characters. Insert the missing parts:\n" +
                        "__ This is a multi-line comment __",
                "/* and */ =",
                "/ and /",
                "/// and ///",
                "//  and  //",
                1,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q4 = new Question(
                "Add the correct data type for the variables\n" +
                        "_____myNum = 9;",
                "int",
                "double",
                "char",
                "bool",
                1,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q5 = new Question(
                "Add the correct data type for the variables\n" +
                        "_____ myDoubleNum = 8.99;",
                "int",
                "double",
                "char",
                "bool",
                2,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q6 = new Question(
                "Add the correct data type for the variables\n" +
                        "______ myLetter = 'A';",
                "int",
                "double",
                "char",
                "bool",
                3,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q7 = new Question(
                "Add the correct data type for the variables\n" +
                        "______ myBoolean = false;",
                "int",
                "double",
                "char",
                "bool",
                4,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q8 = new Question(
                "Add the correct data type for the variables\n" +
                        "______ myText = \"Hello World\";",
                "int",
                "double",
                "char",
                "string",
                4,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q9 = new Question(
                "Multiply 10 with 5, and print the result.\n" +
                        "Console.WriteLine(10 _ 5);",
                "/",
                "%",
                "()",
                "*",
                4,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q10 = new Question(
                "Divide 10 by 5, and print the result.\n" +
                        "Console.WriteLine(10 _ 5);",
                "/ =",
                "%",
                "()",
                "*",
                1,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );;

        Question csharp_q11 = new Question(
                "Use the correct operator to increase the value of the variable x by 1.\n" +
                        "int x = 10;\n" +
                        "x__;",
                "++",
                "//",
                "+=",
                "&&",
                1,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q12 = new Question(
                "Use the addition assignment operator to add the value 5 to the variable x.\n" +
                        "int x = 10;\n" +
                        "x __ 5;",
                "++",
                "//",
                "+=",
                "&&",
                3,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q13 = new Question(
                "Fill in the missing parts to print the value True:\n" +
                        "int x = 10;\n" +
                        "int y = 9;\n" +
                        "Console.WriteLine(\n" +
                        "x__y);",
                "<",
                ">",
                "==",
                "+=",
                2,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q14 = new Question(
                "Print \"Hello World\" if x is greater than y.\n" +
                        "int x = 50;\n" +
                        "int y = 10;\n" +
                        "if (x __ y) \n" +
                        "{\n" +
                        "  Console.WriteLine(\"Hello World\");\n" +
                        "}",
                "<",
                ">",
                "==",
                "+=",
                2,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q15 = new Question(
                "Print \"Hello World\" if x is equal to y.\n" +
                        "int x = 50;\n" +
                        "int y = 50;\n" +
                        "if (x __ y) {\n" +
                        "  Console.WriteLine(\"Hello World\");\n" +
                        "}",
                "<",
                ">",
                "==",
                "+=",
                3,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q16 = new Question(
                "Print i as long as i is less than 6.\n" +
                        "int i = 1;\n" +
                        "while(i _6) {\n" +
                        "  Console.WriteLine(i);\n" +
                        "  i++;\n" +
                        "}",
                "<",
                ">",
                "==",
                "+=",
                1,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q17 = new Question(
                "Use a for loop to print \"Yes\" 5 times:\n" +
                        "for (int i = 0; i < 5; __) {\n" +
                        "  Console.WriteLine(\"Yes\");\n" +
                        "}",
                "+=",
                "++",
                "i++",
                "++i",
                3,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q18 = new Question(
                "Stop the loop if i is 5.\n" +
                        "for (int i = 0; i < 10; i++) {\n" +
                        "  if (i == 5){\n" +
                        "___;\n" +
                        "  }\n" +
                        "  Console.WriteLine(i);\n" +
                        "}",
                "period",
                "stop",
                "break",
                "continue",
                3,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q19 = new Question(
                "Use an access modifier to make the model variable NOT accessible from outside its own class.\n" +
                        "___ string model;",
                "MyClass",
                "private",
                "Class",
                "myObj",
                2,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q20 = new Question(
                "The Car class should inherit the class members from the Vehicle class. Fill in the missing part to make this possible.\n" +
                        "class Car _Vehicle",
                ":",
                ";",
                "()",
                "^",
                1,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );;

        Question csharp_q21 = new Question(
                "To declare a variable of integer type in C#:\n" +
                        "int ____;",
                "int myNumber",
                "integer myNumber;",
                "Int my Number;",
                "",1,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q22 = new Question(
                "To define a method named \"CalculateSum\" that takes two integer parameters and returns their sum in C#:\n" +
                        "public ____ CalculateSum(int a, int b){\n" +
                        "    return a + b;\n" +
                        "}",
                "double",
                "char",
                "int",
                "float",
                3,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q23 = new Question(
                "To create a new instance of the \"Person\" class and assign it to the variable \"newPerson\":\n" +
                        "Person ____ = new Person();",
                "Person",
                "new",
                "newPerson",
                "new Person",
                3,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q24 = new Question(
                "To declare a string variable named \"message\" and assign it the value \"Hello, World!\":\n" +
                        "string ____ = \"Hello, World!\";",
                "message;",
                "message",
                "Message",
                "“message”",
                2,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q25 = new Question(
                "To define a for loop that iterates from 1 to 10 (inclusive) and prints the value of the loop variable:\n" +
                        "for (int i = 1; i <= 10; i++){\n" +
                        "    Console.WriteLine(____);\n" +
                        "}",
                "for",
                "int",
                "10",
                "i",
                4,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q26 = new Question(
                "To define a property named \"Name\" of type string within a class named \"Person\":\n" +
                        "public string ____ { get; set; }",
                "name",
                "string",
                "Name",
                "“Name”",
                3,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q27 = new Question(
                "To instantiate a new list of integers using the List<T> class\n" +
                        "List<int> _____ = new List<int>();",
                "char",
                "double",
                "float",
                "numbers",
                4,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q28 = new Question(
                "To define a switch statement that prints \"Weekend\" if the value of the variable \"day\" is either \"Saturday\" or \"Sunday\":\n" +
                        "switch (____){\n" +
                        "    case \"Saturday\":\n" +
                        "    case \"Sunday\":\n" +
                        "        Console.WriteLine(\"Weekend\");\n" +
                        "        break;\n" +
                        "    default:\n" +
                        "        Console.WriteLine(\"Weekday\");\n" +
                        "        break;\n" +
                        "}",
                "days",
                "week",
                "day",
                " weeks",
                3,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q29 = new Question(
                "To define a nullable integer variable named \"nullableNumber\":\n" +
                        "int? ____ = null;",
                "NullableNumber",
                "nullableNumber",
                "NullableNumber",
                "nullablenumber",
                2,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q30 = new Question(
                "To create a new instance of the class \"Person\" using its default constructor:\n" +
                        "Person person = new _____();",
                "person",
                "“Person”",
                "Person",
                "“person”",
                3,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );;

        Question csharp_q31 = new Question(
                "To implement a for loop that prints the numbers from 1 to 10:\n" +
                        "for (int i = 1; i <= __; i++) \n" +
                        "{\n" +
                        "    Console.WriteLine(i);\n" +
                        "}",
                "10",
                "1",
                "5",
                "2",
                1,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q32 = new Question(
                "To declare a constant integer named \"MaxValue\" with a value of 100:\n" +
                        "const int MaxValue = _____;",
                "10",
                "5",
                "1",
                "100",
                4,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q33 = new Question(
                "To catch any exceptions that might occur within a try-catch block:\n" +
                        "try\n" +
                        "{\n" +
                        "    // Code that might throw exceptions\n" +
                        "}\n" +
                        "catch (_____)\n" +
                        "{\n" +
                        "    // Handle exceptions\n" +
                        "}",
                "Exception",
                "exception",
                "Exeption",
                "exceptions",
                1,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q34 = new Question(
                "To define an array of integers named \"numbers\" with a length of 5:\n" +
                        "int[] numbers = new int[___];",
                "5",
                "1",
                "3+2",
                "1,2,3,4,5",
                1,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q35 = new Question(
                "To instantiate a new instance of the \"List\" class from the System.Collections.Generic namespace:\n" +
                        "List<string> myList = new _____<string>();",
                "List",
                "list",
                "myList",
                "mylist",
                4,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q36 = new Question(
                "To define a class named \"Circle\" that inherits from the \"Shape\" class:\n" +
                        "public class Circle : _____\n" +
                        "{\n" +
                        "    // Class members\n" +
                        "}",
                "class",
                "Circle",
                "Shapes",
                "Shape",
                4,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q37 = new Question(
                "To create a new instance of the Person class and assign it to the variable personObj:\n" +
                        "Person ________ = new Person();",
                "personObj",
                "new",
                "class",
                "personObj:",
                1,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q38 = new Question(
                "To instantiate a new List of strings called strList:\n" +
                        "List<string> _______ = new List<string>();",
                "List",
                "strList:",
                "strList",
                "List<string>",
                3,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q39 = new Question(
                "To declare a property named Age of type int in a class named Person:\n" +
                        "public int _____ { get; set; }",
                "Person",
                "int",
                "Age",
                "new",
                3,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q40 = new Question(
                "To complete the declaration of a constant variable named \"PI\" of type double with a value of 3.14159.\n" +
                        "const double PI = ____;",
                "3.14159.",
                "3.14159;",
                "3 14159",
                "3.14159",
                4,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q41 = new Question(
                "To create a while loop that continues while the variable \"count\" is less than 5, and increments it in each iteration.\n" +
                        "int count = 0;\n" +
                        "while (____) {\n" +
                        "    // loop body\n" +
                        "    count++;\n" +
                        "}",
                "count < 5",
                "count > 5",
                "count < 5;",
                "count = 5",
                1,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q42 = new Question(
                "To complete the C# code that defines an enum named Days with values representing days of the week: Monday, Tuesday, Wednesday, etc.\n" +
                        "enum Days{\n" +
                        "    Monday,\n" +
                        "    Tuesday,\n" +
                        "    Wednesday,\n" +
                        "    Thursday,\n" +
                        "    Friday,\n" +
                        "    Saturday,\n" +
                        "    ____,\n" +
                        "}",
                "days",
                "Sunday",
                "Days",
                "Sunday,",
                2,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q43 = new Question(
                "To complete the C# code that declares an array named numbers containing the integers 4, 7, and 2.\n" +
                        "int[] numbers = { ____, ____, ____ };",
                "2,4,7",
                "4,7,2",
                "7,4,2",
                "2,7,4",
                2,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q44 = new Question(
                "To create a for loop that prints the numbers from 1 to 10.\n" +
                        "for (int i = __; i <= 10; i++){\n" +
                        "    Console.WriteLine(i);\n" +
                        "}",
                "2",
                "0",
                "1",
                "10",
                3,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q45 = new Question(
                "To complete the C# code snippet and instantiate an object of the \"Car\" class, passing \"Toyota\" as the parameter to the constructor:\n" +
                        "Car myCar = new Car(____);",
                "Toyota",
                "Car",
                "myCar",
                "new",
                1,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q46 = new Question(
                "To define a static method named \"PrintMessage\" that takes a string parameter and displays the message using Console.WriteLine:\n" +
                        "public static void ____ (string message){\n" +
                        "    Console.WriteLine(message);\n" +
                        "}",
                "method",
                "class",
                "parameter",
                "PrintMessage",
                4,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q47 = new Question(
                "To declare a nullable integer variable named \"age\":\n" +
                        "int? ____ = null;",
                "22",
                "birthdate",
                "Age",
                "age",
                3,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q48 = new Question(
                "To complete the if statement that checks if the variable temperature is greater than 30. If true, it prints \"It's hot!\"\n" +
                        "int temperature = 32;\n" +
                        "if (___________){\n" +
                        "    Console.WriteLine(\"It's hot!\");\n" +
                        "}",
                "temperature > 30",
                "temperature == 30",
                "temperature < 30",
                "temperature = 30",
                1,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q49 = new Question(
                "To declare a method named CalculateSum that takes two parameters a and b of type int and returns their sum as an int.\n" +
                        "______ CalculateSum(int a, int b){\n" +
                        "    return a + b;\n" +
                        "}",
                "int",
                "char",
                "double",
                "float",
                1,
                Question.DIFFICULTY_HARD,
                Category.Csharp
        );

        Question csharp_q50 = new Question(
                "To declare a constant of type double named PI with a value of 3.14159.\n" +
                        "const ________ PI = 3.14159;",
                "float",
                "int",
                "double",
                "char",
                3,
                Question.DIFFICULTY_HARD,
                Category.Csharp
                );


        insertQuestion(csharp_q1);
        insertQuestion(csharp_q2);
        insertQuestion(csharp_q3);
        insertQuestion(csharp_q4);
        insertQuestion(csharp_q5);
        insertQuestion(csharp_q6);
        insertQuestion(csharp_q7);
        insertQuestion(csharp_q8);
        insertQuestion(csharp_q9);
        insertQuestion(csharp_q10);
        insertQuestion(csharp_q11);
        insertQuestion(csharp_q12);
        insertQuestion(csharp_q13);
        insertQuestion(csharp_q14);
        insertQuestion(csharp_q15);
        insertQuestion(csharp_q16);
        insertQuestion(csharp_q17);
        insertQuestion(csharp_q18);
        insertQuestion(csharp_q19);
        insertQuestion(csharp_q20);
        insertQuestion(csharp_q21);
        insertQuestion(csharp_q22);
        insertQuestion(csharp_q23);
        insertQuestion(csharp_q24);
        insertQuestion(csharp_q25);
        insertQuestion(csharp_q26);
        insertQuestion(csharp_q27);
        insertQuestion(csharp_q28);
        insertQuestion(csharp_q29);
        insertQuestion(csharp_q30);
        insertQuestion(csharp_q31);
        insertQuestion(csharp_q32);
        insertQuestion(csharp_q33);
        insertQuestion(csharp_q34);
        insertQuestion(csharp_q35);
        insertQuestion(csharp_q36);
        insertQuestion(csharp_q37);
        insertQuestion(csharp_q38);
        insertQuestion(csharp_q39);
        insertQuestion(csharp_q40);
        insertQuestion(csharp_q41);
        insertQuestion(csharp_q42);
        insertQuestion(csharp_q43);
        insertQuestion(csharp_q44);
        insertQuestion(csharp_q45);
        insertQuestion(csharp_q46);
        insertQuestion(csharp_q47);
        insertQuestion(csharp_q48);
        insertQuestion(csharp_q49);
        insertQuestion(csharp_q50);


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