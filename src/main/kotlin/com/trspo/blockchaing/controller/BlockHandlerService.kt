package com.trspo.blockchaing.controller

import com.google.protobuf.Empty
import com.trspo.blockchaing.entity.Block
import com.trspo.blockchaing.repo.BlockChainRepository
import com.trspo.blockchaing.services.MessageProducer
import com.trspo.grpc.block.AddBlockRequest
import com.trspo.grpc.block.BlockServiceGrpc
import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService
import org.springframework.beans.factory.annotation.Autowired

@GrpcService
class BlockHandlerService : BlockServiceGrpc.BlockServiceImplBase() {
    @Autowired
    lateinit var repository: BlockChainRepository

    @Autowired
    lateinit var messageProducer: MessageProducer

    override fun addMinedBlock(request: AddBlockRequest, responseObserver: StreamObserver<Empty>) {
        val minedBlock: Block = Block.fromRequestToBlock(request)
        repository.save(minedBlock)
        messageProducer.sendStartMessage()
    }

}