#!/usr/bin/env bash

currentDir=$(pwd)
"$currentDir/../gradle-profiler/build/install/gradle-profiler/bin/gradle-profiler" --profile jprofiler \
    --jprofiler-alloc \
    --jprofiler-heapdump \
    --jprofiler-home="/Applications/JProfiler.app/" \
    --studio-install-dir="/Applications/Android Studio Meerkat.app" \
    --studio-sandbox-dir="$currentDir/profile-out/studio-sandbox" \
    --gradle-version="8.11.1" \
    --project-dir="$currentDir" \
    --scenario-file "$currentDir/scenario.config" "runSync"
