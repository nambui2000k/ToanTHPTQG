package vn.poly.toanthptqg.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import vn.poly.toanthptqg.data.model.ExamDid;

public class DataBaseExamDid extends SQLiteOpenHelper {
    private static String DB_PATH;
    private static String DB_NAME = "examDid.db";
    private SQLiteDatabase mDataBase;
    private final Context mContext;


    // do đường dẫn ở phiên bản API > 17 thay đổi nên chúng ta cần kiểm tra nhé
    public DataBaseExamDid(Context context) {
        super(context, DB_NAME, null, 1);// 1? Its database Version
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.mContext = context;
    }

    public void createDataBase() {
        //If the database does not exist, copy it from the assets.

        boolean mDataBaseExist = checkDataBase();
        if (!mDataBaseExist) {
            this.getReadableDatabase();
            this.close();
            try {
                //Copy the database from assests
                copyDataBase();
                Log.e("TAG", "createDatabase database created");
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    //Check that the database exists here: /data/data/your package/databases/Da Name
    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + DB_NAME);
        //Log.v("dbFile", dbFile + "   "+ dbFile.exists());
        return dbFile.exists();
    }

    //Copy the database from assets
    private void copyDataBase() throws IOException {
        InputStream mInput = mContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0) {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    //Open the database, so we can query it
    public boolean openDataBase() throws SQLException {
        String mPath = DB_PATH + DB_NAME;
        //Log.v("mPath", mPath);
        mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return mDataBase != null;
    }

    @Override
    public synchronized void close() {
        if (mDataBase != null)
            mDataBase.close();
        super.close();
    }

    public long insertExamDid(ExamDid examDid) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
//        contentValues.put("MaHDCT", hoaDonChiTiet.getMaHDCT());
        contentValues.put("idExam", examDid.getIdExam());
        contentValues.put("as1", examDid.getAs1());
        contentValues.put("as2", examDid.getAs2());
        contentValues.put("as3", examDid.getAs3());
        contentValues.put("as4", examDid.getAs4());
        contentValues.put("as5", examDid.getAs5());
        contentValues.put("as6", examDid.getAs6());
        contentValues.put("as7", examDid.getAs7());
        contentValues.put("as8", examDid.getAs8());
        contentValues.put("as9", examDid.getAs9());
        contentValues.put("as10", examDid.getAs10());
        contentValues.put("as11", examDid.getAs11());
        contentValues.put("as12", examDid.getAs12());
        contentValues.put("as13", examDid.getAs13());
        contentValues.put("as14", examDid.getAs14());
        contentValues.put("as15", examDid.getAs15());
        contentValues.put("as16", examDid.getAs16());
        contentValues.put("as17", examDid.getAs17());
        contentValues.put("as18", examDid.getAs18());
        contentValues.put("as19", examDid.getAs19());
        contentValues.put("as20", examDid.getAs20());
        contentValues.put("as21", examDid.getAs21());
        contentValues.put("as22", examDid.getAs22());
        contentValues.put("as23", examDid.getAs23());
        contentValues.put("as24", examDid.getAs24());
        contentValues.put("as25", examDid.getAs25());
        contentValues.put("as26", examDid.getAs26());
        contentValues.put("as27", examDid.getAs27());
        contentValues.put("as28", examDid.getAs28());
        contentValues.put("as29", examDid.getAs29());
        contentValues.put("as30", examDid.getAs30());
        contentValues.put("as31", examDid.getAs31());
        contentValues.put("as32", examDid.getAs32());
        contentValues.put("as33", examDid.getAs33());
        contentValues.put("as34", examDid.getAs34());
        contentValues.put("as35", examDid.getAs35());
        contentValues.put("as36", examDid.getAs36());
        contentValues.put("as37", examDid.getAs37());
        contentValues.put("as38", examDid.getAs38());
        contentValues.put("as39", examDid.getAs39());
        contentValues.put("as40", examDid.getAs40());
        contentValues.put("as41", examDid.getAs41());
        contentValues.put("as42", examDid.getAs42());
        contentValues.put("as43", examDid.getAs43());
        contentValues.put("as44", examDid.getAs44());
        contentValues.put("as45", examDid.getAs45());
        contentValues.put("as46", examDid.getAs46());
        contentValues.put("as47", examDid.getAs47());
        contentValues.put("as48", examDid.getAs48());
        contentValues.put("as49", examDid.getAs49());
        contentValues.put("as50", examDid.getAs50());


        long result = sqLiteDatabase.insert("examDid", null, contentValues);
        sqLiteDatabase.close();
        return result;

    }

    public long updateExamDid(ExamDid examDid) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("idExam", examDid.getIdExam());
        contentValues.put("as1", examDid.getAs1());
        contentValues.put("as2", examDid.getAs2());
        contentValues.put("as3", examDid.getAs3());
        contentValues.put("as4", examDid.getAs4());
        contentValues.put("as5", examDid.getAs5());
        contentValues.put("as6", examDid.getAs6());
        contentValues.put("as7", examDid.getAs7());
        contentValues.put("as8", examDid.getAs8());
        contentValues.put("as9", examDid.getAs9());
        contentValues.put("as10", examDid.getAs10());
        contentValues.put("as11", examDid.getAs11());
        contentValues.put("as12", examDid.getAs12());
        contentValues.put("as13", examDid.getAs13());
        contentValues.put("as14", examDid.getAs14());
        contentValues.put("as15", examDid.getAs15());
        contentValues.put("as16", examDid.getAs16());
        contentValues.put("as17", examDid.getAs17());
        contentValues.put("as18", examDid.getAs18());
        contentValues.put("as19", examDid.getAs19());
        contentValues.put("as20", examDid.getAs20());
        contentValues.put("as21", examDid.getAs21());
        contentValues.put("as22", examDid.getAs22());
        contentValues.put("as23", examDid.getAs23());
        contentValues.put("as24", examDid.getAs24());
        contentValues.put("as25", examDid.getAs25());
        contentValues.put("as26", examDid.getAs26());
        contentValues.put("as27", examDid.getAs27());
        contentValues.put("as28", examDid.getAs28());
        contentValues.put("as29", examDid.getAs29());
        contentValues.put("as30", examDid.getAs30());
        contentValues.put("as31", examDid.getAs31());
        contentValues.put("as32", examDid.getAs32());
        contentValues.put("as33", examDid.getAs33());
        contentValues.put("as34", examDid.getAs34());
        contentValues.put("as35", examDid.getAs35());
        contentValues.put("as36", examDid.getAs36());
        contentValues.put("as37", examDid.getAs37());
        contentValues.put("as38", examDid.getAs38());
        contentValues.put("as39", examDid.getAs39());
        contentValues.put("as40", examDid.getAs40());
        contentValues.put("as41", examDid.getAs41());
        contentValues.put("as42", examDid.getAs42());
        contentValues.put("as43", examDid.getAs43());
        contentValues.put("as44", examDid.getAs44());
        contentValues.put("as45", examDid.getAs45());
        contentValues.put("as46", examDid.getAs46());
        contentValues.put("as47", examDid.getAs47());
        contentValues.put("as48", examDid.getAs48());
        contentValues.put("as49", examDid.getAs49());
        contentValues.put("as50", examDid.getAs50());


        long result = sqLiteDatabase.update("examDid", contentValues, "idExam" + "=?", new String[]{String.valueOf(examDid.getIdExam())});
        sqLiteDatabase.close();
        return result;

    }

    public List<ExamDid> getAllExamDidByIdExam(String IdExam) {
        List<ExamDid> examDidList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String select = "SELECT * FROM examDid WHERE idExam='"+IdExam +"'";

        Cursor cursor = sqLiteDatabase.rawQuery(select, null);
        if (cursor.moveToFirst()) {
            do {
                ExamDid examDid = new ExamDid();
                examDid.setIdExam(cursor.getString(0));
                examDid.setAs1(cursor.getString(1));
                examDid.setAs2(cursor.getString(2));
                examDid.setAs3(cursor.getString(3));
                examDid.setAs4(cursor.getString(4));
                examDid.setAs5(cursor.getString(5));
                examDid.setAs6(cursor.getString(6));
                examDid.setAs7(cursor.getString(7));
                examDid.setAs8(cursor.getString(8));
                examDid.setAs9(cursor.getString(9));
                examDid.setAs10(cursor.getString(10));
                examDid.setAs11(cursor.getString(11));
                examDid.setAs12(cursor.getString(12));
                examDid.setAs13(cursor.getString(13));
                examDid.setAs14(cursor.getString(14));
                examDid.setAs15(cursor.getString(15));
                examDid.setAs16(cursor.getString(16));
                examDid.setAs17(cursor.getString(17));
                examDid.setAs18(cursor.getString(18));
                examDid.setAs19(cursor.getString(19));
                examDid.setAs20(cursor.getString(20));
                examDid.setAs21(cursor.getString(21));
                examDid.setAs22(cursor.getString(22));
                examDid.setAs23(cursor.getString(23));
                examDid.setAs24(cursor.getString(24));
                examDid.setAs25(cursor.getString(25));
                examDid.setAs26(cursor.getString(26));
                examDid.setAs27(cursor.getString(27));
                examDid.setAs28(cursor.getString(28));
                examDid.setAs29(cursor.getString(29));
                examDid.setAs30(cursor.getString(30));
                examDid.setAs31(cursor.getString(31));
                examDid.setAs32(cursor.getString(32));
                examDid.setAs33(cursor.getString(33));
                examDid.setAs34(cursor.getString(34));
                examDid.setAs35(cursor.getString(35));
                examDid.setAs36(cursor.getString(36));
                examDid.setAs37(cursor.getString(37));
                examDid.setAs38(cursor.getString(38));
                examDid.setAs39(cursor.getString(39));
                examDid.setAs40(cursor.getString(40));
                examDid.setAs41(cursor.getString(41));
                examDid.setAs42(cursor.getString(42));
                examDid.setAs43(cursor.getString(43));
                examDid.setAs44(cursor.getString(44));
                examDid.setAs45(cursor.getString(45));
                examDid.setAs46(cursor.getString(46));
                examDid.setAs47(cursor.getString(47));
                examDid.setAs48(cursor.getString(48));
                examDid.setAs49(cursor.getString(49));
                examDid.setAs50(cursor.getString(50));

                examDidList.add(examDid);


            } while (cursor.moveToNext());

            cursor.close();

        }

        sqLiteDatabase.close();
        return examDidList;
    }

    public List<ExamDid> getAllexamDid() {
        List<ExamDid> examDidList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String select = "SELECT * FROM examDid";

        Cursor cursor = sqLiteDatabase.rawQuery(select, null);
        if (cursor.moveToFirst()) {
            do {
                ExamDid examDid = new ExamDid();
                examDid.setIdExam(cursor.getString(0));
                examDid.setAs1(cursor.getString(1));
                examDid.setAs2(cursor.getString(2));
                examDid.setAs3(cursor.getString(3));
                examDid.setAs4(cursor.getString(4));
                examDid.setAs5(cursor.getString(5));
                examDid.setAs6(cursor.getString(6));
                examDid.setAs7(cursor.getString(7));
                examDid.setAs8(cursor.getString(8));
                examDid.setAs9(cursor.getString(9));
                examDid.setAs10(cursor.getString(10));
                examDid.setAs11(cursor.getString(11));
                examDid.setAs12(cursor.getString(12));
                examDid.setAs13(cursor.getString(13));
                examDid.setAs14(cursor.getString(14));
                examDid.setAs15(cursor.getString(15));
                examDid.setAs16(cursor.getString(16));
                examDid.setAs17(cursor.getString(17));
                examDid.setAs18(cursor.getString(18));
                examDid.setAs19(cursor.getString(19));
                examDid.setAs20(cursor.getString(20));
                examDid.setAs21(cursor.getString(21));
                examDid.setAs22(cursor.getString(22));
                examDid.setAs23(cursor.getString(23));
                examDid.setAs24(cursor.getString(24));
                examDid.setAs25(cursor.getString(25));
                examDid.setAs26(cursor.getString(26));
                examDid.setAs27(cursor.getString(27));
                examDid.setAs28(cursor.getString(28));
                examDid.setAs29(cursor.getString(29));
                examDid.setAs30(cursor.getString(30));
                examDid.setAs31(cursor.getString(31));
                examDid.setAs32(cursor.getString(32));
                examDid.setAs33(cursor.getString(33));
                examDid.setAs34(cursor.getString(34));
                examDid.setAs35(cursor.getString(35));
                examDid.setAs36(cursor.getString(36));
                examDid.setAs37(cursor.getString(37));
                examDid.setAs38(cursor.getString(38));
                examDid.setAs39(cursor.getString(39));
                examDid.setAs40(cursor.getString(40));
                examDid.setAs41(cursor.getString(41));
                examDid.setAs42(cursor.getString(42));
                examDid.setAs43(cursor.getString(43));
                examDid.setAs44(cursor.getString(44));
                examDid.setAs45(cursor.getString(45));
                examDid.setAs46(cursor.getString(46));
                examDid.setAs47(cursor.getString(47));
                examDid.setAs48(cursor.getString(48));
                examDid.setAs49(cursor.getString(49));
                examDid.setAs50(cursor.getString(50));

                examDidList.add(examDid);


            } while (cursor.moveToNext());

            cursor.close();

        }

        sqLiteDatabase.close();
        return examDidList;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
