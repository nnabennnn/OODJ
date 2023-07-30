#!/bin/bash

# Function to prompt the user to proceed or cancel
function prompt_proceed_cancel() {
  read -r -p "Proceed? [Y/n]: " response
  case "$response" in
    [yY][eE][sS]|[yY]|"")
      return 0
      ;;
    [nN][oO]|[nN])
      return 1
      ;;
    *)
      echo "Invalid input. Please type 'Y' to proceed or 'N' to cancel."
      prompt_proceed_cancel
      ;;
  esac
}

# Prompt the user to proceed or cancel
echo "Step 1: git status"
prompt_proceed_cancel || exit 1

# Step 2: git add .
echo "Step 2: git add ."
git add .
if [ $? -ne 0 ]; then
  echo "Error: Failed to add changes to the staging area."
  exit 1
fi

# Step 3: git commit -m "string"
echo "Step 3: git commit -m \"string\""
read -r -p "Enter the commit message: " commit_message
git commit -m "$commit_message"
if [ $? -ne 0 ]; then
  echo "Error: Failed to commit changes with message \"$commit_message\"."
  exit 1
fi

# Step 4: git pull origin main
echo "Step 4: git pull origin main"
prompt_proceed_cancel || exit 1
git pull origin main
if [ $? -ne 0 ]; then
  echo "Error: Failed to pull changes from the remote main branch."
  exit 1
fi

# Step 5: git push origin main
echo "Step 5: git push origin main"
prompt_proceed_cancel || exit 1
git push origin main
if [ $? -ne 0 ]; then
  echo "Error: Failed to push changes to the remote main branch."
  exit 1
fi

echo "All steps completed successfully."

