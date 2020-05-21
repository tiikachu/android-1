/**
 * ownCloud Android client application
 *
 * @author David González Verdugo
 * @author Abel García de Prada
 * Copyright (C) 2020 ownCloud GmbH.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.owncloud.android.dependecyinjection

import com.owncloud.android.data.capabilities.datasources.mapper.OCCapabilityMapper
import com.owncloud.android.data.sharing.shares.datasources.mapper.OCShareMapper
import com.owncloud.android.data.sharing.shares.datasources.mapper.RemoteShareMapper
import com.owncloud.android.data.capabilities.datasources.mapper.RemoteCapabilityMapper
import com.owncloud.android.data.user.datasources.mapper.RemoteUserAvatarMapper
import com.owncloud.android.data.user.datasources.mapper.RemoteUserInfoMapper
import com.owncloud.android.data.user.datasources.mapper.RemoteUserQuotaMapper
import com.owncloud.android.data.user.datasources.mapper.UserQuotaMapper
import com.owncloud.android.providers.ContextProvider
import com.owncloud.android.providers.CoroutinesDispatcherProvider
import com.owncloud.android.providers.OCContextProvider
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val commonModule = module {
    factory { OCCapabilityMapper() }
    factory { OCShareMapper() }
    factory { UserQuotaMapper() }

    factory { RemoteCapabilityMapper() }
    factory { RemoteShareMapper() }
    factory { RemoteUserInfoMapper() }
    factory { RemoteUserQuotaMapper() }
    factory { RemoteUserAvatarMapper() }

    single { CoroutinesDispatcherProvider() }
    factory<ContextProvider> { OCContextProvider(androidContext()) }
}
