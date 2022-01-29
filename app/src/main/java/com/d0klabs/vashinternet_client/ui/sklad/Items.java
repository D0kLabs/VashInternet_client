package com.d0klabs.vashinternet_client.ui.sklad;

import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.d0klabs.vashinternet_client.MainActivity;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Items {
    public static List<android.widget.Button> recyclerItemList = new List<Button>() {
        @Override
        public int size() {
            if (!recyclerItemList.isEmpty()) {
                if (recyclerItemList == null) {
                    recyclerItemList.add(0, MainActivity.zero);
                    return 0;
                }
                recyclerItemList.add(0, MainActivity.zero);
                return 0;
            } else {
                return recyclerItemList.size();
            }
        }

        @Override
        public boolean isEmpty() {
            if(recyclerItemList == null){
                recyclerItemList.add(MainActivity.zero);
                return true;
            }
            else {
                return false;
            }
        }

        @Override
        public boolean contains(@Nullable @org.jetbrains.annotations.Nullable Object o) {
            return false;
        }

        @NonNull
        @NotNull
        @Override
        public Iterator<Button> iterator() {
            return null;
        }

        @NonNull
        @NotNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @NonNull
        @NotNull
        @Override
        public <T> T[] toArray(@NonNull @NotNull T[] ts) {
            return null;
        }

        @Override
        public boolean add(Button button) {
            //On click and by form ... or by webface
            //before add, review params of button!
            //there business constuctor must be!
            if (recyclerItemList == null){
                recyclerItemList.add(recyclerItemList.size()+1,button);
                return true;
            } else return  false;
        }

        @Override
        public boolean remove(@Nullable @org.jetbrains.annotations.Nullable Object o) {
            //remove only by webface!
            return false;
        }

        @Override
        public boolean containsAll(@NonNull @NotNull Collection<?> collection) {
            //sync thread maybe
            return false;
        }

        @Override
        public boolean addAll(@NonNull @NotNull Collection<? extends Button> collection) {
            return false;
        }

        @Override
        public boolean addAll(int i, @NonNull @NotNull Collection<? extends Button> collection) {
            return false;
        }

        @Override
        public boolean removeAll(@NonNull @NotNull Collection<?> collection) {
            return false;
        }

        @Override
        public boolean retainAll(@NonNull @NotNull Collection<?> collection) {
            return false;
        }

        @Override
        public void clear() {
            //only by webface

        }

        @Override
        public Button get(int i) {
            return null;
        }

        @Override
        public Button set(int i, Button button) {
            return null;
        }

        @Override
        public void add(int i, Button button) {

        }

        @Override
        public Button remove(int i) {
            return null;
        }

        @Override
        public int indexOf(@Nullable @org.jetbrains.annotations.Nullable Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(@Nullable @org.jetbrains.annotations.Nullable Object o) {
            //TODO: HERE DO INDEXATION!!!
            return 0;
        }

        @NonNull
        @NotNull
        @Override
        public ListIterator<Button> listIterator() {
            return null;
        }

        @NonNull
        @NotNull
        @Override
        public ListIterator<Button> listIterator(int i) {
            return null;
        }

        @NonNull
        @NotNull
        @Override
        public List<Button> subList(int i, int i1) {
            return null;
        }
    };

    public Items() {
    }

    public static void initList(){

            recyclerItemList.add(0, MainActivity.zero);

    }
}
