/*******************************************************************************
 * Copyright 2012 The Infinit.e Open Source Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.ikanow.infinit.e.data_model.custom;

import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.JobContext;

import com.mongodb.hadoop.MongoInputFormat;

public class InfiniteMongoInputFormat extends MongoInputFormat
{	
	@Override
	public List<InputSplit> getSplits(JobContext context) 
	{
		final Configuration hadoopConfiguration = context.getConfiguration();
		final InfiniteMongoConfig conf = new InfiniteMongoConfig( hadoopConfiguration );
		return InfiniteMongoSplitter.calculateSplits(conf);
	}
}
