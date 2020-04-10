package com.will.asgard.loki.model.concurrent.chapter4;

import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * @ClassName LockFreeVector
 * @Description TODO
 * @Auther maolingwei
 * @Date 2020-04-09 14:45
 * @Version 1.0
 **/
public class LockFreeVector<E> {
	private static final int N_BUCKET = 30;
	private static final int FIRST_BUCKET_SIZE = 8;

	private AtomicReferenceArray<AtomicReferenceArray<E>> buckets;
	private AtomicReferenceArray<Descriptor<E>> descriptor;

	public LockFreeVector() {
		buckets = new AtomicReferenceArray<>(N_BUCKET);
		buckets.set(0, new AtomicReferenceArray<>(FIRST_BUCKET_SIZE));

//		descriptor = new AtomicReferenceArray<Descriptor<E>>(new Descriptor(0, null));
	}

	private static class Descriptor<E> {
		private int size;
		volatile WriteDescriptor<E> writeop;

		public Descriptor(int size, WriteDescriptor<E> writeop) {
			this.size = size;
			this.writeop = writeop;
		}

		public void completeWrite() {
			WriteDescriptor<E> tmpOp = writeop;
			if (tmpOp != null) {
				tmpOp.doIt();
				writeop = null;
			}

		}
	}

	private static class WriteDescriptor<E> {
		private E oldV;
		private E newV;
		private AtomicReferenceArray<E> addr;
		private int addrIndex;

		public WriteDescriptor(AtomicReferenceArray<E> addr, int addrIndex, E oldV, E newV) {
			this.addr = addr;
			this.addrIndex = addrIndex;
			this.oldV = oldV;
			this.newV = newV;
		}

		public void doIt() {
			addr.compareAndSet(addrIndex, oldV, newV);
		}
	}


}
