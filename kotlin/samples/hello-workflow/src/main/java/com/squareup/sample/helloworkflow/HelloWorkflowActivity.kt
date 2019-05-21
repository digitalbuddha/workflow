/*
 * Copyright 2019 Square Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.sample.helloworkflow

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.squareup.workflow.ui.ViewRegistry
import com.squareup.workflow.ui.WorkflowActivityRunner
import com.squareup.workflow.ui.setContentWorkflow

@Suppress("EXPERIMENTAL_API_USAGE")
class HelloWorkflowActivity : AppCompatActivity() {
  private val viewRegistry = ViewRegistry(HelloCoordinator)
  private lateinit var runner: WorkflowActivityRunner<Unit>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    runner = setContentWorkflow(viewRegistry, HelloWorkflow, savedInstanceState)
  }

  override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    runner.onSaveInstanceState(outState)
  }
}
