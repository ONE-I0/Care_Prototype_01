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
                "True", "False", "-------","-------", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q1);

        Question java_easy_q2 = new Question("Java supports multiple inheritance, allowing a class to extend multiple classes.",
                "True", "False", "-------","-------", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q2);

        Question java_easy_q3 = new Question("The break statement is used to exit from a loop prematurely.",
                "True", "False", "-------","-------", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q3);

        Question java_easy_q4 = new Question("In Java, the String class is mutable, meaning its value can be changed after creation.",
                "True", "False", "-------","-------", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q4);

        Question java_easy_q5 = new Question("The NullPointerException is a checked exception in Java.",
                "True", "False", "-------","-------", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q5);

        Question java_easy_q6 = new Question("The && operator in Java is a logical OR operator.",
                "True", "False", "-------","-------", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q6);

        Question java_easy_q7 = new Question("An interface in Java can have method implementations.",
                "True", "False", "-------","-------", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q7);

        Question java_easy_q8 = new Question("The ArrayList class in Java is a resizable array implementation.",
                "True", "False", "-------","-------", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q8);

        Question java_easy_q9 = new Question("The final keyword in Java is used to declare constant variables that cannot be modified.",
                "True", "False", "-------","-------", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q9);

        Question java_easy_q10 = new Question("The equals() method in Java compares the memory addresses of two objects.",
                "True", "False", "-------","-------", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q10);

        Question java_easy_q11 = new Question("The do-while loop in Java always executes its code block at least once.",
                "True", "False", "-------","-------", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q11);

        Question java_easy_q12 = new Question("Java allows direct memory manipulation through pointers.",
                "True", "False", "-------","-------", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q12);

        Question java_easy_q13= new Question("The Math.random() method in Java returns a random number between 0 (inclusive) and 1 (exclusive).",
                "True", "False", "-------","-------", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q13);

        Question java_easy_q14 = new Question("The StringBuilder class in Java is mutable and used for creating modifiable strings.",
                "True", "False", "-------","-------", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q14);

        Question java_easy_q15 = new Question("The super keyword in Java is used to call the superclass's constructor.",
                "True", "False", "-------","-------", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q15);

        Question java_easy_q16 = new Question("The instance of operator in Java is used to check if an object is an instance of a specific class or its subclasses.",
                "True", "False", "-------","-------", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q16);

        Question java_easy_q17 = new Question("A try block in Java must always be followed by a catch block.",
                "True", "False", "-------","-------", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q17);

        Question java_easy_q18 = new Question("The switch statement in Java can only be used with int and char data types.",
                "True", "False", "-------","-------", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q18);

        Question java_easy_q19 = new Question("Java has a built-in pair class to store two values together.",
                "True", "False", "-------","-------", 2,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q19);

        Question java_easy_q20 = new Question("The NullPointerException occurs when a program attempts to access a member of a null object.",
                "True", "False", "-------","-------", 1,
                Question.DIFFICULTY_EASY, Category.JAVA);
        insertQuestion(java_easy_q20);

        //--------------------------JAVA MEDIUM------------------------------
        Question java_medium_q1 = new Question("What is Java?",
                "A web browser", "An operating system", "A programming language","-------", 3,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q1);

        Question java_medium_q2 = new Question("Which of the following is not a Java primitive data type?",
                "int", "double", "String","-------", 3,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q2);

        Question java_medium_q3 = new Question("Which keyword is used to define a class in Java?",
                "class", "public", "void","-------", 1,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q3);

        Question java_medium_q4 = new Question("What is the purpose of the ‘main’ method in a Java program?",
                "It is the entry point of the program.", "It is used to declare variables.", "It is used to define constructors.","-------", 1,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q4);

        Question java_medium_q5 = new Question("Which operator is used for logical AND in Java?",
                "&&", "||", "&","-------", 1,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q5);

        Question java_medium_q6 = new Question("What is the purpose of the ‘import’ statement in Java?",
                "To import external libraries", "To enable multi-threading", "To access the internet","-------", 1,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q6);

        Question java_medium_q7 = new Question("Which access modifier makes a method or variable accessible only within its own class?",
                "public", "private", "protected","-------", 2,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q7);

        Question java_medium_q8 = new Question("What is the correct syntax to write a single-line comment in Java?",
                "// This is a comment", "/* This is a comment */", "' This is a comment’","-------", 1,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q8);

        Question java_medium_q9 = new Question("What is the purpose of the break statement in Java?",
                "To exit a loop or switch statement prematurely.", "To end the program execution.", "To throw an exception.","-------", 1,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q9);

        Question java_medium_q10 = new Question("Which of the following is NOT a core principle of Object-Oriented Programming (OOP)?",
                "Inheritance", "Modularity", "Polymorphism","-------", 2,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q10);

        Question java_medium_q11 = new Question("Which loop is guaranteed to execute at least once in Java?",
                "for loop", "while loop", "do-while loop","-------", 3,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q11);

        Question java_medium_q12 = new Question("Which Java keyword is used to inherit a class?",
                "extend", "implements", "extends","-------", 3,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q12);

        Question java_medium_q13 = new Question("Which keyword is used to create an object of a class in Java?",
                "create", "build", "new","-------", 3,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q13);

        Question java_medium_q14 = new Question("In Java, arrays are indexed starting from:",
                "0", "1", "-1","-------", 1,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q14);

        Question java_medium_q15 = new Question("Which operator is used for inequality comparison in Java?",
                "!=", "<>", "==","-------", 1,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q15);

        Question java_medium_q16 = new Question("What is the range of the char data type in Java?",
                "-128 to 127", "'\\u0000' to '\\uffff'", "-32768 to 32767","-------", 2,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q16);

        Question java_medium_q17 = new Question("Which method is automatically called when an object is garbage collected in Java?",
                "finalize()", "delete()", "remove()","-------", 1,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q17);

        Question java_medium_q18 = new Question("Which keyword is used to handle exceptions in Java?",
                "handle", "try", "catch","-------", 3,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q18);

        Question java_medium_q19 = new Question("How many \"else\" statements can be used with a single \"if\" statement?",
                "Only one", "As many as needed", "Two","-------", 1,
                Question.DIFFICULTY_MEDIUM, Category.JAVA);
        insertQuestion(java_medium_q19);

        Question java_medium_q20 = new Question("Which operator is used to compare two values for equality in Java?",
                "==", "=", "!=","-------", 1,
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