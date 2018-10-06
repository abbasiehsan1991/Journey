/*
 *  Copyright 2017 Google Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package codenevisha.ir.app.journey.util

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import codenevisha.ir.app.journey.data.AppRepository
import codenevisha.ir.app.journey.home.ViewmodelMain


/**
 * A creator is used to inject the product ID into the ViewModel
 *
 *
 * This creator is to showcase how to inject dependencies into ViewModels. It's not
 * actually necessary in this case, as the product ID can be passed in a public method.
 */
class ViewModelFactory constructor(private val mApplication: Application, private val mAppRepository: AppRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(ViewmodelMain::class.java)) {
            return ViewmodelMain(mAppRepository, mApplication) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: Add your new ViewModel into ViewmodelFactory.class")
    }
}
