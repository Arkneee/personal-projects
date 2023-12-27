package com.example.lab1q2.provider;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MovieDao_Impl implements MovieDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Movie> __insertionAdapterOfMovie;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllMovies;

  private final SharedSQLiteStatement __preparedStmtOfDeleteOldMovies;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCostlyMovies;

  public MovieDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfMovie = new EntityInsertionAdapter<Movie>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `movies` (`movieID`,`movieName`,`movieYear`,`movieCountry`,`movieGenre`,`movieCost`,`movieKeyword`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Movie value) {
        stmt.bindLong(1, value.getId());
        if (value.getMovieD() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getMovieD());
        }
        if (value.getYearD() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getYearD());
        }
        if (value.getCountryD() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCountryD());
        }
        if (value.getGenreD() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getGenreD());
        }
        if (value.getCostD() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCostD());
        }
        if (value.getKeywordD() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getKeywordD());
        }
      }
    };
    this.__preparedStmtOfDeleteAllMovies = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete FROM movies";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteOldMovies = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete from movies where movieYear < 2010";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteCostlyMovies = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete from movies where movieCost = (SELECT(MAX(movieCost)) FROM movies)";
        return _query;
      }
    };
  }

  @Override
  public void addMovie(final Movie movie) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfMovie.insert(movie);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllMovies() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllMovies.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllMovies.release(_stmt);
    }
  }

  @Override
  public void deleteOldMovies() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteOldMovies.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteOldMovies.release(_stmt);
    }
  }

  @Override
  public void deleteCostlyMovies() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCostlyMovies.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteCostlyMovies.release(_stmt);
    }
  }

  @Override
  public LiveData<List<Movie>> getAllMovies() {
    final String _sql = "SELECT * from movies";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"movies"}, false, new Callable<List<Movie>>() {
      @Override
      public List<Movie> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "movieID");
          final int _cursorIndexOfMovieD = CursorUtil.getColumnIndexOrThrow(_cursor, "movieName");
          final int _cursorIndexOfYearD = CursorUtil.getColumnIndexOrThrow(_cursor, "movieYear");
          final int _cursorIndexOfCountryD = CursorUtil.getColumnIndexOrThrow(_cursor, "movieCountry");
          final int _cursorIndexOfGenreD = CursorUtil.getColumnIndexOrThrow(_cursor, "movieGenre");
          final int _cursorIndexOfCostD = CursorUtil.getColumnIndexOrThrow(_cursor, "movieCost");
          final int _cursorIndexOfKeywordD = CursorUtil.getColumnIndexOrThrow(_cursor, "movieKeyword");
          final List<Movie> _result = new ArrayList<Movie>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Movie _item;
            final String _tmpMovieD;
            if (_cursor.isNull(_cursorIndexOfMovieD)) {
              _tmpMovieD = null;
            } else {
              _tmpMovieD = _cursor.getString(_cursorIndexOfMovieD);
            }
            final String _tmpYearD;
            if (_cursor.isNull(_cursorIndexOfYearD)) {
              _tmpYearD = null;
            } else {
              _tmpYearD = _cursor.getString(_cursorIndexOfYearD);
            }
            final String _tmpCountryD;
            if (_cursor.isNull(_cursorIndexOfCountryD)) {
              _tmpCountryD = null;
            } else {
              _tmpCountryD = _cursor.getString(_cursorIndexOfCountryD);
            }
            final String _tmpGenreD;
            if (_cursor.isNull(_cursorIndexOfGenreD)) {
              _tmpGenreD = null;
            } else {
              _tmpGenreD = _cursor.getString(_cursorIndexOfGenreD);
            }
            final String _tmpCostD;
            if (_cursor.isNull(_cursorIndexOfCostD)) {
              _tmpCostD = null;
            } else {
              _tmpCostD = _cursor.getString(_cursorIndexOfCostD);
            }
            final String _tmpKeywordD;
            if (_cursor.isNull(_cursorIndexOfKeywordD)) {
              _tmpKeywordD = null;
            } else {
              _tmpKeywordD = _cursor.getString(_cursorIndexOfKeywordD);
            }
            _item = new Movie(_tmpMovieD,_tmpYearD,_tmpCountryD,_tmpGenreD,_tmpCostD,_tmpKeywordD);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
