# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.14

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /Applications/CLion.app/Contents/bin/cmake/mac/bin/cmake

# The command to remove a file.
RM = /Applications/CLion.app/Contents/bin/cmake/mac/bin/cmake -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Users/narayan/Desktop/workspace/HW5CPP

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Users/narayan/Desktop/workspace/HW5CPP/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/HW5CPP.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/HW5CPP.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/HW5CPP.dir/flags.make

CMakeFiles/HW5CPP.dir/main.cpp.o: CMakeFiles/HW5CPP.dir/flags.make
CMakeFiles/HW5CPP.dir/main.cpp.o: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/narayan/Desktop/workspace/HW5CPP/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/HW5CPP.dir/main.cpp.o"
	/Library/Developer/CommandLineTools/usr/bin/c++  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles/HW5CPP.dir/main.cpp.o -c /Users/narayan/Desktop/workspace/HW5CPP/main.cpp

CMakeFiles/HW5CPP.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/HW5CPP.dir/main.cpp.i"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E /Users/narayan/Desktop/workspace/HW5CPP/main.cpp > CMakeFiles/HW5CPP.dir/main.cpp.i

CMakeFiles/HW5CPP.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/HW5CPP.dir/main.cpp.s"
	/Library/Developer/CommandLineTools/usr/bin/c++ $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S /Users/narayan/Desktop/workspace/HW5CPP/main.cpp -o CMakeFiles/HW5CPP.dir/main.cpp.s

# Object files for target HW5CPP
HW5CPP_OBJECTS = \
"CMakeFiles/HW5CPP.dir/main.cpp.o"

# External object files for target HW5CPP
HW5CPP_EXTERNAL_OBJECTS =

HW5CPP: CMakeFiles/HW5CPP.dir/main.cpp.o
HW5CPP: CMakeFiles/HW5CPP.dir/build.make
HW5CPP: CMakeFiles/HW5CPP.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/narayan/Desktop/workspace/HW5CPP/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable HW5CPP"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/HW5CPP.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/HW5CPP.dir/build: HW5CPP

.PHONY : CMakeFiles/HW5CPP.dir/build

CMakeFiles/HW5CPP.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/HW5CPP.dir/cmake_clean.cmake
.PHONY : CMakeFiles/HW5CPP.dir/clean

CMakeFiles/HW5CPP.dir/depend:
	cd /Users/narayan/Desktop/workspace/HW5CPP/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/narayan/Desktop/workspace/HW5CPP /Users/narayan/Desktop/workspace/HW5CPP /Users/narayan/Desktop/workspace/HW5CPP/cmake-build-debug /Users/narayan/Desktop/workspace/HW5CPP/cmake-build-debug /Users/narayan/Desktop/workspace/HW5CPP/cmake-build-debug/CMakeFiles/HW5CPP.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/HW5CPP.dir/depend

