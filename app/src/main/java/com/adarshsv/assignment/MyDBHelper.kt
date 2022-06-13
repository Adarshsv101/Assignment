package com.adarshsv.assignment

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.FileObserver.CREATE

class MyDBHelper(context : Context): SQLiteOpenHelper(context,"USERDB",null,1){
    override fun onCreate(db:SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE USERS(UID INTEGER PRIMARY KEY AUTOINCREMENT,UNAME TEXT,PASSWORD TEXT)")
        db?.execSQL("INSERT INTO USERS(UNAME,PASSWORD) VALUES('adrianjoshi@gmail.com','adrian')")


    }
        override fun onUpgrade(db: SQLiteDatabase?, pl:Int, p2:Int) {

        }
}