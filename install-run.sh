
#!/bin/bash

# Function to check if command exist
is_Command_Exist(){
    type "$1"
    return $?
}

# Function to check if package installed
is_Package_Installed(){
    dpkg -l | grep "$1"
    return $?
}

# Function to install a specific package
install_package(){
    sudo apt update
    sudo DEBIAN_FRONTEND=noninteractive apt install -y "$1"
}

# Function to unpack a debian
unpack_installer(){
    sudo dpkg -i "$1"
    sudo apt --fix-broken install
}

# Check if Java exists or not
if is_Command_Exist "java"; then
    echo "Java is installed on this Ubuntu machine."
else
    echo "Java is not installed."
    install_package "openjdk-11-jre-headless"
fi

# Check if Maven exists or not
if is_Command_Exist "mvn"; then
    echo "Maven is installed on this Ubuntu machine."
else
    echo "Maven is not installed."
    install_package "maven"
fi

# Check if Xvfb exists or not
if is_Package_Installed "xvfb"; then
    echo "Xvfb is installed on this Ubuntu machine."
else
    echo "Xvfb is not installed."
    install_package "xvfb"
fi

# Check if Chrome exists or not
if is_Package_Installed "chrome"; then
    echo "chrome is installed on this Ubuntu machine."
else
    echo "chrome is not installed."
    unpack_installer "google-chrome-stable_114.0.5735.198-1_amd64.deb"
fi
