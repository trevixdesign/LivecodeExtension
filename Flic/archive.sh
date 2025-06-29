#!/bin/bash

rm -f ../../../livecode/_build/com.livecode.library.native.flic

cp -af ../../../livecode/_build/mac/Debug/packaged_extensions/com.livecode.library.native.flic \
	../../../livecode/_build

cp -af ../../../livecode/android-armv7-bin/packaged_extensions/com.livecode.library.native.flic/code \
	../../../livecode/_build/com.livecode.library.native.flic

cp -af ../../../livecode/_build/ios/iphoneos13.2/Debug/packaged_extensions/com.livecode.library.native.flic/code/ \
	../../../livecode/_build/com.livecode.library.native.flic/code

cd ../../../livecode/_build/com.livecode.library.native.flic

zip -r ../com.livecode.library.native.flic.lce *