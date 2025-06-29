{
	'includes':
	[
		'../../../livecode/common.gypi',
		'../../../livecode/config/android.gypi',
	],

	'variables':
	{
		'java_sources':
		[
			'ButtonListener.java',
		],
	},

	'targets':
	[
		{
			'target_name': 'fliclibrary',
			'type': 'none',

			'conditions':
			[
				[
					'OS == "android" or OS == "ios"',
					{
						'dependencies':
						[
							'fliclibrary-build',
						],
					},
				],
			],
		},

		{
			'target_name': 'fliclibrary-compile',
			'type': 'none',

			'sources':
			[
				'<@(java_sources)',
			],

			'conditions':
			[
				[
					'OS == "android"',
					{
						'includes':
						[
							'../../../livecode/config/java.gypi',
						],

						'variables':
						{
							'java_classes_dir_name': 'classes_fliclibrary',
							'java_extra_classpath':
							[
								'jvm-android/flic2lib.jar',
							],
						},
					}
				],
			],
		},

		{
			'target_name': 'fliclibrary-jar',
			'type': 'none',

			'conditions':
			[
				[
					'OS == "android"',
					{
						'dependencies':
						[
							'fliclibrary-compile',
						],

						'sources':
						[
							'<@(java_sources)',
						],

						'actions':
						[
							{
								'action_name': 'jar',
								'message': 'JAR',

								'inputs':
								[
									'<@(_sources)',
								],

								'outputs':
								[
									'<(PRODUCT_DIR)/FLICLibrary.jar',
								],

								'action':
								[
									'<(jar_path)',
									'cf',
									'<@(_outputs)',
									'-C', '<(PRODUCT_DIR)/classes_fliclibrary',
									'.',
								],
							},
						],
					},
				],
			]
		},

		{
			'target_name': 'fliclibrary-build',
			'type': 'none',

			'conditions':
			[
				[
					'OS == "android"',
					{
						'dependencies':
						[
							'fliclibrary-jar',
						],

						'copies':
						[
							{
								'destination': '<(PRODUCT_DIR)/packaged_extensions/com.livecode.library.native.flic/code/jvm-android/',
								'files':
								[
									'<(PRODUCT_DIR)/FLICLibrary.jar',
									'jvm-android/flic2lib.jar',
								],
							},
						],
					},
				],
				[
					'OS == "ios"',
					{
						'copies':
						[
							{
								'destination': '<(PRODUCT_DIR)/packaged_extensions/com.livecode.library.native.flic/code/universal-ios/',
								'files':
								[
									'universal-ios/flic2lib.framework',
								],
							},
						],
					},
				]
			],
		},
	],
}
