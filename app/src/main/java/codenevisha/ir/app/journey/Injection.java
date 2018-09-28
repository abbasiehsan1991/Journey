package codenevisha.ir.app.journey;

import android.content.Context;
import android.support.annotation.NonNull;

import codenevisha.ir.app.journey.data.AppDataSource;
import codenevisha.ir.app.journey.data.AppRepository;
import codenevisha.ir.app.journey.data.local.HomeLocalDataSource;
import codenevisha.ir.app.journey.data.local.database.AppDatabase;
import codenevisha.ir.app.journey.data.remote.HomeRemoteDataSource;
import codenevisha.ir.app.journey.util.AppExecutors;


/**
 * Enables injection for
 * {@link AppDataSource} at compile time.
 * */

public class Injection {

  public static AppRepository provideApplicationRepository(@NonNull Context context) {

    AppDatabase database = AppDatabase.Companion.getInstance(context);

    return AppRepository.Companion.getInstance(
      HomeRemoteDataSource.Companion.getInstance(),
      HomeLocalDataSource.Companion.getInstance(new AppExecutors(), database.userDao())
    );

  }
}
